package com.example.englishcenter.Responses;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data

public class NguoiDungResponse {
    private Long manguoidung;
    private String hoten;
    private Date ngaysinh;
    private String gioitinh;
    private String sdt;
    private String diachi;
    private String email;
    private String tendangnhap;
    private String matkhau;
    private String tenchucvu;
    private Long maloaichucvu;
}
