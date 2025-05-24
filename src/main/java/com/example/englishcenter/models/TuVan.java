package com.example.englishcenter.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbltuvan")
public class TuVan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matuvan;

    private String hoten;
    private LocalDate ngaygui;
    private String sdt;
    private String nghenghiep;
    private String cauhoituvan;
    private String trangthai;
}
