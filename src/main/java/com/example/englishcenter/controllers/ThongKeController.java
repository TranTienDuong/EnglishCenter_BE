package com.example.englishcenter.controllers;

import com.example.englishcenter.dtos.KhoaHocDoanhThuDTO;
import com.example.englishcenter.services.KhoaHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/thongke")
@RequiredArgsConstructor
public class ThongKeController {
    @Autowired
    private KhoaHocService khoaHocService;

    @GetMapping("/doanhthu")
    public ResponseEntity<List<KhoaHocDoanhThuDTO>> getDoanhThuKhoaHoc() {
        List<KhoaHocDoanhThuDTO> doanhThuKhoaHoc = khoaHocService.getDoanhThuKhoaHoc();
        return ResponseEntity.ok(doanhThuKhoaHoc);
    }

    @GetMapping("/soluonghocvien")
    public ResponseEntity<List<Map<String, Object>>> getSoLuongHocVienMoiKhoaHoc() {
        List<Map<String, Object>> response = khoaHocService.getSoLuongHocVienMoiKhoaHoc();
        return ResponseEntity.ok(response);
    }

}
