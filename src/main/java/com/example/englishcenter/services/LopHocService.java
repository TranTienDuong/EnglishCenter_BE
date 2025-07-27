package com.example.englishcenter.services;

import com.example.englishcenter.Responses.LopHocResponse;
import com.example.englishcenter.Responses.NguoiDungInLopHocResponse;
import com.example.englishcenter.repositories.DiemDanhRepository;
import com.example.englishcenter.dtos.LopHocDTO;
import com.example.englishcenter.exceptions.DataNotFoundException;
import com.example.englishcenter.models.*;
import com.example.englishcenter.repositories.*;
import com.example.englishcenter.services.iservices.ILopHocService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LopHocService implements ILopHocService {
    private final LopHocRepository lopHocRepository;
    private final KhoaHocRepository khoaHocRepository;
    private final NguoiLopHocRepository nguoiLopHocRepository;
    private final NguoiDungRepository nguoiDungRepository;
    private final ThoiKhoaBieuRepository thoiKhoaBieuRepository;
    private final PhongHocRepository phongHocRepository;
    private final DiemDanhRepository diemDanhRepository;

    @Override
    public LopHoc getLopHocById(long MaLop) {
        return lopHocRepository.findById(MaLop)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy lớp"));
    }

    @Override
    public LopHocResponse getLopHocDetails(Long malop) {
        // Fetch LopHoc entity by malop
        LopHoc lopHoc = lopHocRepository.findById(malop).orElseThrow(() -> new RuntimeException("LopHoc not found"));

        // Prepare the response
        LopHocResponse response = LopHocResponse.builder()
                .malop(lopHoc.getMalop())
                .tenlophoc(lopHoc.getTenlophoc())
                .ngaykhaigiang(lopHoc.getNgaykhaigiang())
                .thoigianhoc(lopHoc.getThoigianhoc())
                .thuhoc(lopHoc.getThuhoc())
                .cahoc(lopHoc.getCahoc())
                .tenkhoahoc(lopHoc.getKhoaHoc().getTenkhoahoc())
                .tenphonghoc(thoiKhoaBieuRepository.findDistinctTenPhongByMaLop(lopHoc.getMalop()))
                .hocvien(lopHoc.getNguoiLopHocs().stream()
                        .filter(nlh -> nlh.getNguoiDung().getChucVu().getLoaiChucvu().getMaloaichucvu() == 1) // Filter students
                        .map(nlh -> new NguoiDungInLopHocResponse(
                                nlh.getNguoiDung().getManguoidung(),
                                nlh.getNguoiDung().getHoten(),
                                nlh.getNguoiDung().getGioitinh(),
                                nlh.getNguoiDung().getSdt(),
                                nlh.getNguoiDung().getDiachi(),
                                nlh.getNguoiDung().getEmail(),
                                nlh.getTrangThai(),
                                nlh.getDiemkiemtra(),
                                nlh.getDiemcuoiki()))
                        .collect(Collectors.toList()))
                .giangVien(lopHoc.getNguoiLopHocs().stream()
                        .filter(nlh -> nlh.getNguoiDung().getChucVu().getLoaiChucvu().getMaloaichucvu() == 2) // Filter teachers
                        .map(nlh -> new NguoiDungInLopHocResponse(
                                nlh.getNguoiDung().getManguoidung(),
                                nlh.getNguoiDung().getHoten(),
                                nlh.getNguoiDung().getGioitinh(),
                                nlh.getNguoiDung().getSdt(),
                                nlh.getNguoiDung().getDiachi(),
                                nlh.getNguoiDung().getEmail(),
                                nlh.getTrangThai(),
                                nlh.getDiemkiemtra(),
                                nlh.getDiemcuoiki()))
                        .collect(Collectors.toList()))
                .build();

        return response;
    }


    @Override
    public List<LopHocResponse> getAllLopHoc() {
        return lopHocRepository.findAll().stream().map(lopHoc -> {
            return LopHocResponse.builder()
                    .malop(lopHoc.getMalop())
                    .tenlophoc(lopHoc.getTenlophoc())
                    .ngaykhaigiang(lopHoc.getNgaykhaigiang())
                    .thoigianhoc(lopHoc.getThoigianhoc())
                    .thuhoc(lopHoc.getThuhoc())
                    .cahoc(lopHoc.getCahoc())
                    .tenkhoahoc(lopHoc.getKhoaHoc().getTenkhoahoc())
                    .tenphonghoc(thoiKhoaBieuRepository.findDistinctTenPhongByMaLop(lopHoc.getMalop()))
                    .hocvien(lopHoc.getNguoiLopHocs().stream()
                            .filter(nlh -> nlh.getNguoiDung().getChucVu().getMachucvu() == 1) // Filter students
                            .map(nlh -> new NguoiDungInLopHocResponse(
                                    nlh.getNguoiDung().getManguoidung(),
                                    nlh.getNguoiDung().getHoten(),
                                    nlh.getNguoiDung().getGioitinh(),
                                    nlh.getNguoiDung().getSdt(),
                                    nlh.getNguoiDung().getDiachi(),
                                    nlh.getNguoiDung().getEmail(),
                                    nlh.getTrangThai(),
                                    nlh.getDiemkiemtra(),
                                    nlh.getDiemcuoiki())
                            )
                            .collect(Collectors.toList()))
                    .giangVien(lopHoc.getNguoiLopHocs().stream()
                            .filter(nlh -> nlh.getNguoiDung().getChucVu().getLoaiChucvu().getMaloaichucvu()==2) // Filter teachers
                            .map(nlh -> new NguoiDungInLopHocResponse(
                                    nlh.getNguoiDung().getManguoidung(),
                                    nlh.getNguoiDung().getHoten(),
                                    nlh.getNguoiDung().getGioitinh(),
                                    nlh.getNguoiDung().getSdt(),
                                    nlh.getNguoiDung().getDiachi(),
                                    nlh.getNguoiDung().getEmail(),
                                    nlh.getTrangThai(),
                                    nlh.getDiemkiemtra(),
                                    nlh.getDiemcuoiki()))
                            .collect(Collectors.toList()))
                    .build();
        }).collect(Collectors.toList());
    }



    @Override
    public ResponseEntity<String> createLopHoc(LopHocDTO lopHocDTO) throws DataNotFoundException {
        KhoaHoc existingKhoaHoc = khoaHocRepository
                .findBytenkhoahoc(lopHocDTO.getTenkhoahoc())
                .orElseThrow(() -> new DataNotFoundException(
                        "Khong tim thay khoa hoc co ma la" + lopHocDTO.getTenkhoahoc()));

        //tách tên gv ra khỏi chuỗi
        String  tengiaovien = lopHocDTO.getGiaovien().split(" - ")[0];
        NguoiDung giaoVien = nguoiDungRepository.findNguoiDungByHoten(tengiaovien);
        if (giaoVien == null) {
            throw new DataNotFoundException("Không tìm thấy giáo viên : " + tengiaovien);
        }

        LopHoc newLopHoc = LopHoc
                .builder()
                .tenlophoc(lopHocDTO.getTenlophoc())
                .ngaykhaigiang(lopHocDTO.getNgaykhaigiang())
                .thoigianhoc(lopHocDTO.getThoigianhoc())
                .thuhoc(lopHocDTO.getThuhoc())
                .cahoc(lopHocDTO.getCahoc())
                .khoaHoc(existingKhoaHoc)
                .build();

        lopHocRepository.save(newLopHoc);

        NguoiLopHoc newNguoiLopHoc = new NguoiLopHoc();
        newNguoiLopHoc.setNguoiDung(giaoVien);
        newNguoiLopHoc.setLopHoc(newLopHoc);
        newNguoiLopHoc.setTrangThai("Đang Học");
        nguoiLopHocRepository.save(newNguoiLopHoc);

        PhongHoc phongHoc = phongHocRepository.findPhongHocByTenphong(lopHocDTO.getPhonghoc());

        //lấy các thời khóa biểu đủ điều kiện
        LocalTime tgbatdau=null,tgketthuc=null;

        switch (lopHocDTO.getCahoc()) {
            case "Sáng":
                tgbatdau = LocalTime.parse("07:00");
                tgketthuc = LocalTime.parse("10:00");
                break;
            case "Chiều":
                tgbatdau = LocalTime.parse("13:00");
                tgketthuc = LocalTime.parse("16:00");
                break;
            case "Tối":
                tgbatdau = LocalTime.parse("18:00");
                tgketthuc = LocalTime.parse("21:00");
                break;
        }

        // Tách chuỗi thành danh sách số nguyên
        List<Integer> thuHocList = Arrays.stream(lopHocDTO.getThuhoc().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<ThoiKhoaBieu> lstTKB = thoiKhoaBieuRepository.getAvaibleTKB(thuHocList,tgbatdau,tgketthuc,phongHoc.getMaphong());
        for(ThoiKhoaBieu thoiKhoaBieu : lstTKB) {
            thoiKhoaBieu.setLophoc(newLopHoc);
            thoiKhoaBieuRepository.save(thoiKhoaBieu);
        }

        // 8. Tạo bản ghi điểm danh cho từng buổi học
        createDiemDanhRecords(newLopHoc, giaoVien, Time.valueOf(tgbatdau), Time.valueOf(tgketthuc));

        return ResponseEntity.ok("them thanh cong");
    }
    private void createDiemDanhRecords(LopHoc lopHoc, NguoiDung giaoVien, Time tgbatdau, Time tgketthuc) {
        // Validate input
        if (lopHoc == null || giaoVien == null || tgbatdau == null || tgketthuc == null) {
            throw new IllegalArgumentException("Tham số không được null");
        }

        // Xác định tổng số buổi học
        String[] parts = lopHoc.getThoigianhoc().split(" ");
        int totalSessions = Integer.parseInt(parts[0]);

        // Xử lý danh sách thứ học (chuyển từ số sang DayOfWeek)
        List<DayOfWeek> thuHocList = Arrays.stream(lopHoc.getThuhoc().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(thu -> {
                    // Chuyển đổi từ số thứ (2-8) sang DayOfWeek (1-7)
                    // Giả sử input: 2=Thứ 2, 3=Thứ 3,..., 8=Chủ nhật
                    return thu == 8 ? DayOfWeek.SUNDAY : DayOfWeek.of(thu - 1);
                })
                .collect(Collectors.toList());

        // Bắt đầu từ ngày khai giảng
        LocalDate currentDate = lopHoc.getNgaykhaigiang().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Tìm ngày học đầu tiên phù hợp (có thể là ngày khai giảng hoặc ngày tiếp theo)
        while (!thuHocList.contains(currentDate.getDayOfWeek())) {
            currentDate = currentDate.plusDays(1);
        }

        int createdSessions = 0;
        int weeksLimit = (totalSessions / thuHocList.size()) + 2; // Giới hạn số tuần

        // Tạo các buổi học
        for (int week = 0; week < weeksLimit && createdSessions < totalSessions; week++) {
            for (DayOfWeek thu : thuHocList) {
                if (createdSessions >= totalSessions) break;

                // Tìm ngày của thứ trong tuần hiện tại
                LocalDate ngayHoc = currentDate.with(thu);

                // Đảm bảo không quay lại ngày trước ngày khai giảng
                if (ngayHoc.isBefore(currentDate)) {
                    ngayHoc = ngayHoc.plusWeeks(1);
                }

                DiemDanh diemDanh = new DiemDanh();
                diemDanh.setMaNguoiDung(giaoVien.getManguoidung().intValue());
                diemDanh.setMaLop(lopHoc.getMalop().intValue());
                diemDanh.setNgayHoc(Date.valueOf(ngayHoc));
                diemDanh.setThoiGianBatDau(tgbatdau);
                diemDanh.setThoiGianKetThuc(tgketthuc);
                diemDanh.setTrangThai("Chưa điểm danh");
                diemDanh.setIsBu(false);

                diemDanhRepository.save(diemDanh);
                createdSessions++;
            }

            // Chuyển sang tuần tiếp theo
            currentDate = currentDate.plusWeeks(1);
        }

        if (createdSessions < totalSessions) {
            throw new IllegalStateException(String.format(
                    "Chỉ tạo được %d/%d buổi học", createdSessions, totalSessions));
        }
    }

    @Override
    public LopHoc updateLopHoc(long MaLop, LopHocDTO lopHocDTO) throws Exception {
        LopHoc existingLopHoc = getLopHocById(MaLop);
        System.out.println(lopHocDTO.getTenlophoc());
        System.out.println(lopHocDTO.getNgaykhaigiang());
        // In ra các trường khác để kiểm tra xem có bị null không
        //coppy cac thuoc tinh tu DTO -> product
        //co the su dung ModelMaper, ObjectMaper

        KhoaHoc existingKhoaHoc = khoaHocRepository
                .findBytenkhoahoc(lopHocDTO.getTenkhoahoc())
                .orElseThrow(() -> new DataNotFoundException(
                        "Khong tim thay khoa hoc co ma la" + lopHocDTO.getTenkhoahoc()));

        existingLopHoc.setTenlophoc(lopHocDTO.getTenlophoc());
        existingLopHoc.setNgaykhaigiang(lopHocDTO.getNgaykhaigiang());
        existingLopHoc.setThoigianhoc(lopHocDTO.getThoigianhoc());
        existingLopHoc.setKhoaHoc(existingKhoaHoc);

        return lopHocRepository.save(existingLopHoc);
    }

    @Transactional
    @Override
    public ResponseEntity<String> deleteLopHocById(long MaLop) {
        diemDanhRepository.deleteByMaLop(MaLop);
        nguoiLopHocRepository.deleteByMaLop(MaLop);
        thoiKhoaBieuRepository.updateMalopToNull(MaLop);
        lopHocRepository.deleteById(MaLop);
        return ResponseEntity.ok("Xóa thành công");
    }

    @Override
    public LopHoc getLopHocByTenLop(String tenLop){
        return lopHocRepository.findBytenlophoc(tenLop);
    }


    public List<LopHoc> getLopCungKhoaHocDeChuyen(Long maLopCu) {
        // Optional: kiểm tra lớp có tồn tại không, hoặc bỏ qua nếu đã kiểm tra ở nơi khác
        if (!lopHocRepository.existsById(maLopCu)) {
            throw new RuntimeException("Lớp hiện tại không tồn tại");
        }

        return lopHocRepository.findLopCungKhoaHoc(maLopCu);
    }

}
