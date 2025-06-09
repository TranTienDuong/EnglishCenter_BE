package com.example.englishcenter.repositories;

import com.example.englishcenter.models.FormNhapHoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormNhapHocRepository extends JpaRepository<FormNhapHoc, Long> {

    Optional<FormNhapHoc> findByEmailOrSdt(String email, String sdt);
}
