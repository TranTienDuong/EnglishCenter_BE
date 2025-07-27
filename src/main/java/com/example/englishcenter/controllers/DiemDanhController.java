package com.example.englishcenter.controllers;

import com.example.englishcenter.dtos.DiemDanhDTO;
import com.example.englishcenter.dtos.DiemDanhRequestDTO;
import com.example.englishcenter.dtos.HuyLopDTO;
import com.example.englishcenter.exceptions.DataNotFoundException;
import com.example.englishcenter.models.DiemDanh;
import com.example.englishcenter.models.PhongHoc;
import com.example.englishcenter.repositories.DiemDanhRepository;
import com.example.englishcenter.services.DiemDanhService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/diemdanh")
public class DiemDanhController {

    @Autowired
    private DiemDanhService diemDanhService;
    @Autowired
    private DiemDanhRepository diemDanhRepository;

    @PostMapping
    public ResponseEntity<DiemDanh> createDiemDanh(@Valid @RequestBody DiemDanhDTO diemDanhDTO) {
        DiemDanh createdDiemDanh = diemDanhService.createDiemDanh(diemDanhDTO);
        return new ResponseEntity<>(createdDiemDanh, HttpStatus.CREATED);
    }

    // Cập nhật trạng thái điểm danh
    @PutMapping("/{maDiemDanh}")
    public ResponseEntity<?> updateDiemDanh(
            @PathVariable Integer maDiemDanh,
            @RequestBody DiemDanhRequestDTO request) {

        // Thêm logic để set diemDanh từ maDiemDanh
        DiemDanh diemDanh = diemDanhRepository.findById(maDiemDanh)
                .orElseThrow(() -> new DataNotFoundException("Buổi học không tồn tại"));
        request.setDiemDanh(diemDanh);

        diemDanhService.updateDiemDanh(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{maGiaoVien}")
    public ResponseEntity<List<DiemDanh>> getDiemDanhByGiaoVienAndDate(
            @PathVariable Integer maGiaoVien,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate ngayHoc) {

        List<DiemDanh> diemDanhList;
        if (ngayHoc != null) {
            // Chuyển đổi LocalDate sang java.sql.Date
            Date sqlDate = Date.valueOf(ngayHoc);
            diemDanhList = diemDanhRepository.findByNguoiDung_ManguoidungAndNgayHoc(maGiaoVien, sqlDate);
        } else {
            diemDanhList = diemDanhRepository.findByNguoiDung_Manguoidung(maGiaoVien);
        }

        return ResponseEntity.ok(diemDanhList);
    }

    // Lấy danh sách điểm danh
    @GetMapping
    public ResponseEntity<List<DiemDanhDTO>> getDiemDanh(
            @RequestParam(required = false) Integer maGiaoVien,
            @RequestParam(required = false) Integer maLop,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate ngayBatDau,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate ngayKetThuc) {

        List<DiemDanhDTO> result = diemDanhService.getDiemDanh(
                maGiaoVien, maLop, ngayBatDau, ngayKetThuc);
        return ResponseEntity.ok(result);
    }
}