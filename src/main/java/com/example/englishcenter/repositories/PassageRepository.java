package com.example.englishcenter.repositories;

import com.example.englishcenter.models.Passage;
import com.example.englishcenter.models.PassageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassageRepository extends JpaRepository<Passage, Integer> {
    List<Passage> findByLoaidoan(PassageType loaidoan);
    List<Passage> findByLoaidoanAndDokho(PassageType loaidoan, Integer dokho);
}
