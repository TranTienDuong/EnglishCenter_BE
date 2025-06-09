package com.example.englishcenter.dtos;

import com.example.englishcenter.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private Integer macauhoi;
    private String dapanchon;
}
