package com.example.englishcenter.Responses;

import lombok.*;

import java.time.LocalTime;
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThoiKhoaBieuRespone {
    private Integer thuhoc;
    private LocalTime tgbatdau;
    private LocalTime tgketthuc;
    private String tenphonghoc;
}