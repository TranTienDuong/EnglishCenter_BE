package com.example.englishcenter.dtos;

import com.example.englishcenter.models.FormNhapHoc;
import com.example.englishcenter.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamResultDTO {
    private Integer maketqua;
    private FormNhapHoc maform;
    private Question macauhoi;
    private String dapanchon;
    private Integer diem;
}
