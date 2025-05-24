package com.example.englishcenter.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblphonghoc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PhongHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maphong;

    @Column(length = 255)
    private String tenphong;
}