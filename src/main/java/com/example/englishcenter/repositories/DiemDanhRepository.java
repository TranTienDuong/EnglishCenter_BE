package com.example.englishcenter.repositories;

import com.example.englishcenter.models.DiemDanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.List;

public interface DiemDanhRepository extends JpaRepository<DiemDanh, Integer> {
    // Tìm theo giáo viên và ngày học cụ thể
    List<DiemDanh> findByNguoiDung_ManguoidungAndNgayHoc(Integer manguoidung, Date ngayHoc);

    // Tìm theo giáo viên
    List<DiemDanh> findByNguoiDung_Manguoidung(Integer manguoidung);
    // Tìm theo giáo viên và khoảng ngày
    List<DiemDanh> findByMaNguoiDungAndNgayHocBetween(Integer maNguoiDung, Date ngayBatDau, Date ngayKetThuc);

    // Tìm theo lớp và khoảng ngày
    List<DiemDanh> findByMaLopAndNgayHocBetween(Integer maLop, Date ngayBatDau, Date ngayKetThuc);

    // Tìm theo giáo viên, lớp và khoảng ngày
    List<DiemDanh> findByMaNguoiDungAndMaLopAndNgayHocBetween(
            Integer maNguoiDung, Integer maLop, Date ngayBatDau, Date ngayKetThuc);

    // Tìm theo khoảng ngày
    List<DiemDanh> findByNgayHocBetween(Date ngayBatDau, Date ngayKetThuc);

    // Tìm theo giáo viên
    List<DiemDanh> findByMaNguoiDung(Integer maNguoiDung);

    // Tìm theo lớp
    List<DiemDanh> findByMaLop(Integer maLop);

    @Modifying
    @Query("DELETE FROM DiemDanh d WHERE d.maLop = :maLop")
    void deleteByMaLop(@Param("maLop") Long maLop);
}