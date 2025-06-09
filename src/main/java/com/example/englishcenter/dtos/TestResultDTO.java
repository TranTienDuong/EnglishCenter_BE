package com.example.englishcenter.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResultDTO {
    private String fullname;
    private String email;
    private String phone;
    private Integer tongsocauhoi;
    private Integer cautraloidung;
    private Integer diem;
    private String trinhdodudoan;
}
