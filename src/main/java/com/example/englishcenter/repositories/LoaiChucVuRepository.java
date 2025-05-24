package com.example.englishcenter.repositories;

import com.example.englishcenter.models.LoaiChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiChucVuRepository extends JpaRepository<LoaiChucVu, Integer> {
}
