package com.raymond.gymapp.controllers;


import com.raymond.gymapp.model.SessionExercise;
import com.raymond.gymapp.service.SessionExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session-exercise")
@RequiredArgsConstructor
public class SessionExerciseController {

    private final SessionExerciseService sessionExerciseService;

    @GetMapping
    public ResponseEntity<List<SessionExercise>> getAllSessionExercises() {
        return ResponseEntity.ok(sessionExerciseService.getAllSessionExercises());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionExercise> getSessionExerciseById(@PathVariable Long id) {
        return ResponseEntity.ok(sessionExerciseService.getSessionExerciseById(id));
    }

    @PostMapping
    public ResponseEntity<SessionExercise> createSessionExercise(@RequestBody SessionExercise sessionExercise) {
        return ResponseEntity.ok(sessionExerciseService.createSessionExercise(sessionExercise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSessionExercise(@PathVariable Long id) {
        sessionExerciseService.deleteSessionExercise(id);
        return ResponseEntity.noContent().build();
    }
}
