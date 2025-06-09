package com.example.englishcenter.controllers;

import com.example.englishcenter.dtos.ExamResultDTO;
import com.example.englishcenter.dtos.TestRequestDTO;
import com.example.englishcenter.dtos.TestResultDTO;
import com.example.englishcenter.models.ExamResult;
import com.example.englishcenter.models.FormNhapHoc;
import com.example.englishcenter.services.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ketquathithu")
public class ExamResultController {
    @Autowired
    private ExamResultService examResultService;

    @GetMapping
    public ResponseEntity<List<ExamResult>> getAll() {
        return ResponseEntity.ok(examResultService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamResult> getById(@PathVariable Integer id) {
        Optional<ExamResult> ketQua = examResultService.getById(id);
        return ketQua.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExamResult> createOrUpdate(@RequestBody ExamResultDTO dto) {
        return ResponseEntity.ok(examResultService.createOrUpdate(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(examResultService.delete(id));
    }

    @GetMapping("/form/{email}/{phone}")
    public ResponseEntity<List<ExamResult>> getByMaForm(@PathVariable String email, @PathVariable String phone) {
        return ResponseEntity.ok(examResultService.getByEmailOrPhone(email, phone));
    }
    @GetMapping("/ketqua/{email}/{phone}")
    public ResponseEntity<TestResultDTO> getTestResult(@PathVariable String email, @PathVariable String phone) {
        return ResponseEntity.ok(examResultService.getTestResultByEmailOrPhone(email, phone));
    }


    @PostMapping("/submit")
    public ResponseEntity<TestResultDTO> submitTest(@RequestBody TestRequestDTO request) {
        return ResponseEntity.ok(examResultService.submitTest(request));
    }
}
