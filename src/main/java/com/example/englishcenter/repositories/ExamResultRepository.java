package com.example.englishcenter.repositories;

import com.example.englishcenter.models.ExamResult;
import com.example.englishcenter.models.FormNhapHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Integer> {
    List<ExamResult> findByMaform(FormNhapHoc maform);

    void deleteByMaform(FormNhapHoc maform);
}
