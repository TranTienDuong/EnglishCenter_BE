package com.example.englishcenter.dtos;

import com.example.englishcenter.models.Passage;
import com.example.englishcenter.models.SkillType;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Integer macauhoi;
    private String noidung;
    private String dapanA;
    private String dapanB;
    private String dapanC;
    private String dapanD;
    private String dapandung;
    private SkillType kynang;
    private Integer dokho;
    private Integer madoan;
}

