package com.example.englishcenter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblketquathithu")
public class ExamResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKetQua")
    private Integer maketqua;

    @ManyToOne
    @JoinColumn(name = "maform", referencedColumnName = "maform")
    @JsonIgnore
    private FormNhapHoc maform;

    @ManyToOne
    @JoinColumn(name = "MaCauHoi", referencedColumnName = "MaCauHoi")
    @JsonIgnore
    private Question macauhoi;

    @Column(name = "DapAnChon")
    private String dapanchon;

    @Column(name = "Diem")
    private Integer diem; // 0: Sai, 1: Đúng
}
