package com.example.englishcenter.controllers;

import com.example.englishcenter.dtos.PassageDTO;
import com.example.englishcenter.models.Passage;
import com.example.englishcenter.models.PassageType;
import com.example.englishcenter.services.PassageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doanthi")
public class PassageController {
    @Autowired
    private PassageService passageService;

    @GetMapping
    public ResponseEntity<List<Passage>> getAll() {
        return ResponseEntity.ok(passageService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passage> getById(@PathVariable Integer id) {
        Optional<Passage> doanThi = passageService.getById(id);
        return doanThi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Tạo mới đoạn thi
    @PostMapping("")
    public ResponseEntity<?> createPassage(
            @Valid @RequestBody PassageDTO passageDTO,
            BindingResult bindingResult
    ) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            Passage created = passageService.create(passageDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Tạo đoạn thi thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // Cập nhật đoạn thi theo ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePassage(
            @PathVariable Integer id,
            @Valid @RequestBody PassageDTO passageDTO,
            BindingResult bindingResult
    ) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            Passage updated = passageService.update(id, passageDTO);
            return ResponseEntity.ok("Cập nhật đoạn thi thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(passageService.delete(id));
    }

    @GetMapping("/{type}/{difficulty}")
    public ResponseEntity<List<Passage>> getByTypeAndDifficulty(
            @PathVariable PassageType type,
            @PathVariable Integer difficulty) {
        return ResponseEntity.ok(passageService.getByTypeAndDifficulty(type, difficulty));
    }
}
