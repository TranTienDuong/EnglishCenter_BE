package com.example.englishcenter.dtos;

import com.example.englishcenter.models.DiemDanh;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HuyLopDTO {
    @NotNull
    private DiemDanh diemDanh;

    @NotBlank
    private String lyDo;

    @NotNull
    @Future
    private LocalDate ngayDayBu;
}