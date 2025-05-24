package com.example.englishcenter.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ChucVuDTO {
    private String tenchucvu;
    private BigDecimal luong;
    private int maloaichucvu;
}
