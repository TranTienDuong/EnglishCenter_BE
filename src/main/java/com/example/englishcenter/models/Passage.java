package com.example.englishcenter.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbldoanthi")
public class Passage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDoan")
    private Integer madoan;

    @Column(name = "TieuDe")
    private String tieude;

    @Column(name = "NoiDung", columnDefinition = "TEXT")
    private String noidung;

    @Column(name = "LoaiDoan")
    @Enumerated(EnumType.STRING)
    private PassageType loaidoan; // READING/LISTENING

    @Column(name = "DoKho")
    private Integer dokho; // 1: Dễ, 2: Trung bình, 3: Khó

    @Column(name = "AudioFile")
    private String audiofile; // chỉ dành cho listening

    @Column(name = "ThoiLuong")
    private Integer thoiluong; // thời lượng audio (giây)

    @OneToMany(mappedBy = "madoan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Question> cauhois;
}
