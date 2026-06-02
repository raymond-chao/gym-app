package com.raymond.gymapp.controllers;

import com.raymond.gymapp.model.WorkoutSession;
import com.raymond.gymapp.service.WorkoutSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class WorkoutSessionController {

    private final WorkoutSessionService workoutSessionService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkoutSession>> getSessionsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(workoutSessionService.getSessionsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutSession> getSessionById(@PathVariable Long id) {
        return ResponseEntity.ok(workoutSessionService.getSessionById(id));
    }

    @PostMapping
    public ResponseEntity<WorkoutSession> createSession(@RequestBody WorkoutSession workoutSession) {
        return ResponseEntity.ok(workoutSessionService.createSession(workoutSession));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        workoutSessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}
