package com.example.englishcenter.repositories;

import com.example.englishcenter.models.LopHoc;
import com.example.englishcenter.models.NguoiDung;
import com.example.englishcenter.models.NguoiLopHoc;
import com.example.englishcenter.models.NguoiLopHocId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NguoiLopHocRepository extends JpaRepository<NguoiLopHoc, NguoiLopHocId> {
    // Truy vấn người dùng trong một lớp học dựa trên mã lớp
    @Query("SELECT nl.nguoiDung FROM NguoiLopHoc nl WHERE nl.lopHoc.malop = :maLop")
    List<NguoiDung> findNguoiDungByLopHoc(@Param("maLop") Long maLop);

    // Xóa tất cả người dùng trong một lớp học dựa trên mã lớp
    @Modifying
    @Query("DELETE FROM NguoiLopHoc n WHERE n.lopHoc.malop = :maLop")
    void deleteByMaLop(@Param("maLop") Long maLop);

    // Truy vấn NguoiLopHoc dựa trên mã người dùng
    @Query("SELECT nl FROM NguoiLopHoc nl WHERE nl.nguoiDung.manguoidung = :maNguoiDungId")
    NguoiLopHoc findNguoiLopHocByMaNguoiDungId(@Param("maNguoiDungId") Long maNguoiDungId);

    @Modifying
    @Query("DELETE FROM NguoiLopHoc nl WHERE nl.nguoiDung.manguoidung = :maNguoiDung")
    void deleteByMaNguoiDung(@Param("maNguoiDung") Long maNguoiDung);

    // Lấy tất cả người dùng trong lớp học với mã lớp
    @Query("SELECT nl.nguoiDung FROM NguoiLopHoc nl WHERE nl.lopHoc.malop = :malop")
    List<NguoiDung> findByLopHoc_MaLop(@Param("malop") Long maLop);

    // Lấy tất cả các lớp học mà người dùng đã tham gia
    @Query("SELECT nl FROM NguoiLopHoc nl WHERE nl.nguoiDung.manguoidung = :manguoidung")
    List<NguoiLopHoc> findNguoiDungBy_MaNguoiDung(@Param("manguoidung") Long manguoidung);


    // Giáo viên đang dạy lớp có trạng thái "Đang Dạy"
    @Query("SELECT nl FROM NguoiLopHoc nl WHERE nl.nguoiDung.manguoidung = :manguoidung AND nl.trangThai = 'Đang Học'")
    List<NguoiLopHoc> findAllGiaoVienDangDay(@Param("manguoidung") Long manguoidung);


    boolean existsById(NguoiLopHocId id);
    boolean existsByNguoiDungAndLopHoc(NguoiDung nguoiDung, LopHoc lopHoc);

    List<NguoiLopHoc> findByNguoiDungAndTrangThai(NguoiDung nguoiDung, String trangThai);
}
