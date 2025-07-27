package com.example.englishcenter.dtos;

import com.example.englishcenter.models.DiemDanh;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiemDanhRequestDTO {
    @NotBlank
    private DiemDanh diemDanh;

    @NotBlank
    private String trangThai;

    private String ghiChu;
}