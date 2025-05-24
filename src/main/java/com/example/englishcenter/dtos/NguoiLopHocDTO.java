package com.example.englishcenter.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiLopHocDTO {
    private int maNguoiDung;
    private int maLop;
    private String trangThai;
    private Float diemKiemTra;
    private Float diemCuoiki;
    private Integer uuDai;
}
