package com.example.englishcenter.dtos;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungDTO {
    private String hoten;
    private Date ngaysinh;
    private String gioitinh;
    private String sdt;

    private String diachi;
    private String email;
    private String tendangnhap;
    private String matkhau;
    private String tenchucvu;
}
