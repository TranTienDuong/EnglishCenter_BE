package com.example.englishcenter.controllers;

import com.example.englishcenter.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/generate")
    public ResponseEntity<Map<String, Object>> generateTest() {
        return ResponseEntity.ok(testService.generateTest());
    }

    @GetMapping("/verify")
    public ResponseEntity<Boolean> verifyStudent(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone) {
        return ResponseEntity.ok(testService.verifyStudent(email, phone));
    }
}
