package com.example.englishcenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblcauhoithithu")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCauHoi")
    private Integer macauhoi;

    @ManyToOne
    @JoinColumn(name = "MaDoan", referencedColumnName = "MaDoan")
    @JsonBackReference
    private Passage madoan;

    @Column(name = "NoiDung", columnDefinition = "TEXT")
    private String noidung;

    @Column(name = "DapAnA", columnDefinition = "TEXT")
    private String dapanA;

    @Column(name = "DapAnB", columnDefinition = "TEXT")
    private String dapanB;

    @Column(name = "DapAnC", columnDefinition = "TEXT")
    private String dapanC;

    @Column(name = "DapAnD", columnDefinition = "TEXT")
    private String dapanD;

    @Column(name = "DapAnDung")
    private String dapandung; // A/B/C/D

    @Column(name = "DoKho")
    private Integer dokho; // 1: Dễ, 2: Trung bình, 3: Khó

    @Column(name = "KyNang")
    @Enumerated(EnumType.STRING)
    private SkillType kynang; // READING/LISTENING/GRAMMAR/VOCABULARY
}
