package com.example.englishcenter.repositories;

import com.example.englishcenter.models.Passage;
import com.example.englishcenter.models.Question;
import com.example.englishcenter.models.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("SELECT q FROM Question q  WHERE q.macauhoi = :id")
    Optional<Question> findWithById(@Param("id") Integer id);
    // Tìm câu hỏi theo kỹ năng và độ khó
    List<Question> findByKynang(SkillType kynang);

    // Tìm theo mã đoạn (nếu madoan là 1 entity)
    List<Question> findByMadoan(Passage madoan);

    // Tìm danh sách kỹ năng
    List<Question> findByKynangInAndDokho(List<SkillType> kynangs, Integer dokho);
}
