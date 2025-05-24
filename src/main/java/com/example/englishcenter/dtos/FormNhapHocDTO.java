package com.example.englishcenter.dtos;

import lombok.*;

import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormNhapHocDTO {
    private String hoten;
    private Date ngaysinh;
    private String gioitinh;
    private String sdt;
    private String tenkhoahoc;
    private String diachi;
    private String email;
    private Date ngaygui;
    private String trangthai;
}
