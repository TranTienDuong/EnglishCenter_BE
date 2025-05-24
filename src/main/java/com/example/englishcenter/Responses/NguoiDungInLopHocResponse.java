package com.example.englishcenter.Responses;

import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NguoiDungInLopHocResponse {
    private Long manguoidung;
    private String hoten;
    private String gioitinh;
    private String sdt;
    private String diachi;
    private String email;
    private String trangThai;
    private Float diemkiemtra;
    private Float diemdiemcuoiki;
}
