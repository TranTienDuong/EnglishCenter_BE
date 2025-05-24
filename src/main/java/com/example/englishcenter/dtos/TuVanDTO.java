package com.example.englishcenter.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TuVanDTO {
    private Long matuvan;

    private String hoten;
    private LocalDate ngaygui;
    private String sdt;
    private String nghenghiep;
    private String cauhoituvan;
    private String trangthai;
}
