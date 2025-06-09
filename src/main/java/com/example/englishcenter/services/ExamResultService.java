package com.example.englishcenter.services;

import com.example.englishcenter.dtos.AnswerDTO;
import com.example.englishcenter.dtos.ExamResultDTO;
import com.example.englishcenter.dtos.TestRequestDTO;
import com.example.englishcenter.dtos.TestResultDTO;
import com.example.englishcenter.models.*;
import com.example.englishcenter.repositories.QuestionRepository;
import com.example.englishcenter.repositories.ExamResultRepository;
import com.example.englishcenter.repositories.FormNhapHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamResultService {
    @Autowired
    private ExamResultRepository examResultRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private FormNhapHocRepository formNhapHocRepository;

    public List<ExamResult> getAll() {
        return examResultRepository.findAll();
    }

    public Optional<ExamResult> getById(Integer id) {
        return examResultRepository.findById(id);
    }

    public ExamResult createOrUpdate(ExamResultDTO dto) {
        ExamResult ketQua = ExamResult.builder()
                .maketqua(dto.getMaketqua())
                .maform(dto.getMaform())
                .macauhoi(dto.getMacauhoi())
                .dapanchon(dto.getDapanchon())
                .diem(dto.getDiem())
                .build();
        return examResultRepository.save(ketQua);
    }

    public Boolean delete(Integer id) {
        try {
            examResultRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ExamResult> getByEmailOrPhone(String email, String phone) {
        // Tìm FormNhapHoc bằng email hoặc số điện thoại
        Optional<FormNhapHoc> formOpt = formNhapHocRepository.findByEmailOrSdt(email, phone);
        if (!formOpt.isPresent()) {
            throw new RuntimeException("Student not registered");
        }

        FormNhapHoc form = formOpt.get();

        // Trả về danh sách kết quả thi
        return examResultRepository.findByMaform(form);
    }

    @Transactional
    public TestResultDTO submitTest(TestRequestDTO request) {
        // 1. Kiểm tra thí sinh
        Optional<FormNhapHoc> formOpt = formNhapHocRepository.findByEmailOrSdt(request.getEmail(), request.getPhone());
        if (!formOpt.isPresent()) {
            throw new RuntimeException("Student not registered");
        }

        FormNhapHoc form = formOpt.get();

        // 2. Xóa kết quả cũ nếu có
        examResultRepository.deleteByMaform(form);

        // 3. Tính điểm và lưu kết quả
        int correctAnswers = 0;
        int totalQuestions = request.getCautraloi().size();

        for (AnswerDTO answer : request.getCautraloi()) {
            if (answer.getDapanchon() == null || answer.getDapanchon().trim().isEmpty()) {
                continue; // bỏ qua câu chưa trả lời
            }
            Optional<Question> questionOpt = questionRepository.findById(answer.getMacauhoi());
            if (questionOpt.isPresent()) {
                Question question = questionOpt.get();
                int score = question.getDapandung().equals(answer.getDapanchon()) ? 1 : 0;
                correctAnswers += score;

                ExamResult result = ExamResult.builder()
                        .macauhoi(question)
                        .maform(form)
                        .dapanchon(answer.getDapanchon())
                        .diem(score)
                        .build();
                examResultRepository.save(result);
            }
        }

        // Calculate score percentage
        int scorePercentage = (int) (((double) correctAnswers / 60) * 9);
        String level = determineLevel(scorePercentage);

        // 4. Cập nhật form
        form.setDiemthithu((float) scorePercentage);
        form.setNgaythithu(new java.util.Date());
        form.setTrinhdodudoan(level);
        formNhapHocRepository.save(form);

        // 5. Trả về kết quả
        return TestResultDTO.builder()
                .fullname(form.getHoten())
                .email(form.getEmail())
                .phone(form.getSdt())
                .tongsocauhoi(totalQuestions)
                .cautraloidung(correctAnswers)
                .diem(scorePercentage)
                .trinhdodudoan(level)
                .build();
    }

    private String determineLevel(int score) {
        if (score >= 7) return "7.0+";
        if (score >= 6) return "6.0-6.5";
        if (score >= 5) return "5.0-5.5";
        return "Beginner";
    }
    public TestResultDTO getTestResultByEmailOrPhone(String email, String phone) {
        // 1. Tìm thí sinh
        Optional<FormNhapHoc> formOpt = formNhapHocRepository.findByEmailOrSdt(email, phone);
        if (!formOpt.isPresent()) {
            throw new RuntimeException("Student not registered");
        }

        FormNhapHoc form = formOpt.get();

        // 2. Lấy danh sách kết quả đã lưu
        List<ExamResult> examResults = examResultRepository.findByMaform(form);
        if (examResults.isEmpty()) {
            throw new RuntimeException("No test results found for this student.");
        }

        // 3. Tính số câu đúng và tổng câu hỏi
        int totalQuestions = examResults.size();
        int correctAnswers = (int) examResults.stream()
                .filter(er -> er.getDiem() != null && er.getDiem() == 1)
                .count();

        // 4. Dùng điểm đã lưu hoặc tính lại điểm nếu cần
        int scorePercentage = (int) (((double) correctAnswers / 60) * 9);
        String level = determineLevel(scorePercentage);

        // 5. Trả về DTO
        return TestResultDTO.builder()
                .fullname(form.getHoten())
                .email(form.getEmail())
                .phone(form.getSdt())
                .tongsocauhoi(totalQuestions)
                .cautraloidung(correctAnswers)
                .diem(scorePercentage)
                .trinhdodudoan(level)
                .build();
    }

}
