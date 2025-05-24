package com.example.englishcenter.repositories;

import com.example.englishcenter.models.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LopHocRepository extends JpaRepository<LopHoc, Long> {
    LopHoc findBytenlophoc(String tenLop);

    @Query("SELECT l2 FROM LopHoc l1 JOIN LopHoc l2 ON l1.khoaHoc.makhoahoc = l2.khoaHoc.makhoahoc " +
            "WHERE l1.malop = :maLopCu AND l2.malop <> :maLopCu")
    List<LopHoc> findLopCungKhoaHoc(@Param("maLopCu") Long maLopCu);


}
