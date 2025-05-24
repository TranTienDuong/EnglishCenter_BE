package com.example.englishcenter.repositories;

import com.example.englishcenter.models.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer> {
    ChucVu findByTenchucvu(String tenchucvu);
}
