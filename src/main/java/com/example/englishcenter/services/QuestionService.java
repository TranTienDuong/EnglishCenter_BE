package com.example.englishcenter.services;

import com.example.englishcenter.dtos.QuestionDTO;
import com.example.englishcenter.models.Passage;
import com.example.englishcenter.models.Question;
import com.example.englishcenter.models.SkillType;
import com.example.englishcenter.repositories.PassageRepository;
import com.example.englishcenter.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private PassageRepository passageRepository;

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> getById(Integer id) {
        return questionRepository.findWithById(id);
    }

    public Question create(QuestionDTO dto) {
        Passage passage = null;
        if (dto.getMadoan() != null) {
            passage = passageRepository.findById(dto.getMadoan())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Passage với ID: " + dto.getMadoan()));
        }

        Question question = Question.builder()
                .noidung(dto.getNoidung())
                .dapanA(dto.getDapanA())
                .dapanB(dto.getDapanB())
                .dapanC(dto.getDapanC())
                .dapanD(dto.getDapanD())
                .dapandung(dto.getDapandung())
                .dokho(dto.getDokho())
                .kynang(dto.getKynang())
                .madoan(passage)
                .build();

        return questionRepository.save(question);
    }

    public Question update(Integer id, QuestionDTO dto) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi với ID: " + id));

        Passage passage = null;
        if (dto.getMadoan() != null) {
            passage = passageRepository.findById(dto.getMadoan())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Passage với ID: " + dto.getMadoan()));
        }

        existingQuestion.setNoidung(dto.getNoidung());
        existingQuestion.setDapanA(dto.getDapanA());
        existingQuestion.setDapanB(dto.getDapanB());
        existingQuestion.setDapanC(dto.getDapanC());
        existingQuestion.setDapanD(dto.getDapanD());
        existingQuestion.setDapandung(dto.getDapandung());
        existingQuestion.setDokho(dto.getDokho());
        existingQuestion.setKynang(dto.getKynang());
        existingQuestion.setMadoan(passage);

        return questionRepository.save(existingQuestion);
    }

    public Boolean delete(Integer id) {
        try {
            questionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Question> getBySkill(SkillType kynang) {
        return questionRepository.findByKynang(kynang);
    }

    public List<Question> getBySkillsAndDifficulty(List<SkillType> kynangs, Integer dokho) {
        return questionRepository.findByKynangInAndDokho(kynangs, dokho);
    }

    public List<Question> getByMaDoan(Passage maDoan) {
        return questionRepository.findByMadoan(maDoan);
    }
}
