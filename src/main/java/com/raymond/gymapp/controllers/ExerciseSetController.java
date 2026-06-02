package com.raymond.gymapp.controllers;


import com.raymond.gymapp.model.ExerciseSet;
import com.raymond.gymapp.service.ExerciseSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sets")
@RequiredArgsConstructor
public class ExerciseSetController {

    private final ExerciseSetService exerciseSetService;

    @GetMapping("/{id}")
    public ResponseEntity getExerciseSetById(@PathVariable Long id) {
        return ResponseEntity.ok(exerciseSetService.getExerciseSetById(id));
    }

    @GetMapping("/session/{sessionExerciseId}")
    public ResponseEntity<List<ExerciseSet>> getSetsBySessionExercise(@PathVariable Long sessionExerciseId) {
        return ResponseEntity.ok(exerciseSetService.getSetsBySessionExerciseId(sessionExerciseId));  // rätt metod
    }

    @PostMapping
    public ResponseEntity<ExerciseSet> createExerciseSet(@RequestBody ExerciseSet exerciseSet) {
        return ResponseEntity.ok(exerciseSetService.createExerciseSet(exerciseSet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseSet(@PathVariable Long id) {
        exerciseSetService.deleteExerciseSet(id);
        return ResponseEntity.noContent().build();
    }
}
