package com.example.englishcenter.Responses;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChucVuResponse {
    private  int machucvu;
    private String tenchucvu;
    private BigDecimal luong;
    private int maloaichucvu;
}
