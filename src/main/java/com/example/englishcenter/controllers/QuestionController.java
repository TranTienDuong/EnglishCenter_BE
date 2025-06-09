package com.example.englishcenter.controllers;

import com.example.englishcenter.dtos.QuestionDTO;
import com.example.englishcenter.models.Passage;
import com.example.englishcenter.models.Question;
import com.example.englishcenter.models.SkillType;
import com.example.englishcenter.services.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cauhoi")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAll() {
        return ResponseEntity.ok(questionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getById(@PathVariable Integer id) {
        Optional<Question> cauHoi = questionService.getById(id);
        return cauHoi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> createQuestion(
            @Valid @RequestBody QuestionDTO dto,
            BindingResult bindingResult
    ) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errors);
            }
            questionService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Tạo câu hỏi thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(
            @PathVariable Integer id,
            @Valid @RequestBody QuestionDTO dto,
            BindingResult bindingResult
    ) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errors);
            }
            questionService.update(id, dto);
            return ResponseEntity.ok("Cập nhật câu hỏi thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(questionService.delete(id));
    }

    @GetMapping("/skill/{skill}")
    public ResponseEntity<List<Question>> getBySkill(
            @PathVariable SkillType skill) {
        return ResponseEntity.ok(questionService.getBySkill(skill));
    }

    @GetMapping("/passage/{maDoan}")
    public ResponseEntity<List<Question>> getByMaDoan(@PathVariable Passage maDoan) {
        return ResponseEntity.ok(questionService.getByMaDoan(maDoan));
    }
}
