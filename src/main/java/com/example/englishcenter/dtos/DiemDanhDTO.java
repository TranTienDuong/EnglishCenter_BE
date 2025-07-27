package com.example.englishcenter.dtos;

import com.example.englishcenter.models.DiemDanh;
import com.example.englishcenter.models.LopHoc;
import com.example.englishcenter.models.NguoiDung;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiemDanhDTO {
    private Integer maDiemDanh;
    private NguoiDung nguoiDung;
    private LopHoc lopHoc;
    private LocalDate ngayHoc;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private String trangThai;
    private LocalDateTime thoiGianDiemDanh;
    private String ghiChu;
    private Boolean isBu;
}