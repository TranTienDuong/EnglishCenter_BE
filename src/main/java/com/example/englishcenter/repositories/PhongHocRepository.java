package com.example.englishcenter.repositories;

import com.example.englishcenter.models.PhongHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongHocRepository extends JpaRepository<PhongHoc, Integer> {
    public PhongHoc findPhongHocByTenphong(String tenphong);
}
