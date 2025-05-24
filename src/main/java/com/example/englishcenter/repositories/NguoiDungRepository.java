package com.example.englishcenter.repositories;

import com.example.englishcenter.models.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {
    @Query("SELECT nd FROM NguoiDung nd WHERE nd.chucVu.tenchucvu LIKE %:tenKhoaHoc%")
    List<NguoiDung> findByTenKhoaHoc(@Param("tenKhoaHoc") String tenKhoaHoc);

    NguoiDung findNguoiDungByHoten(String hoten);
    NguoiDung findByTendangnhap(String tendangnhap);

    @Query("SELECT nd FROM NguoiDung nd WHERE nd.chucVu.tenchucvu LIKE %:keyword%")
    List<NguoiDung> findAllGiaoVien(@Param("keyword") String keyword);


}
