package com.example.englishcenter.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestRequestDTO {
    private String fullname;
    private String email;
    private String phone;
    private List<AnswerDTO> cautraloi;
}

