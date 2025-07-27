package com.example.englishcenter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbldiemdanh")
public class DiemDanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDiemDanh")
    private Integer maDiemDanh;

    @Column(name = "MaNguoiDung")
    private Integer maNguoiDung;

    @Column(name = "MaLop")
    private Integer maLop;

    @Column(name = "NgayHoc")
    private Date ngayHoc;

    @Column(name = "ThoiGianBatDau")
    private Time thoiGianBatDau;

    @Column(name = "ThoiGianKetThuc")
    private Time thoiGianKetThuc;

    @Column(name = "TrangThai")
    private String trangThai;

    @Column(name = "ThoiGianDiemDanh")
    private Timestamp thoiGianDiemDanh;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "IsBu")
    private Boolean isBu;

    // Quan hệ với bảng Người dùng
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaNguoiDung", insertable = false, updatable = false)
    @JsonIgnore
    private NguoiDung nguoiDung;

    // Quan hệ với bảng Lớp học
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaLop", insertable = false, updatable = false)
    @JsonIgnore
    private LopHoc lopHoc;
}