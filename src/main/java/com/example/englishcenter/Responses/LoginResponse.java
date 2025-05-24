package com.example.englishcenter.Responses;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private Long manguoidung;
    private String tenloaichucvu;
    private String tennguoidung;
}
