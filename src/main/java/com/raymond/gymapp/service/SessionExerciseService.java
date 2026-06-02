package com.raymond.gymapp.service;


import com.raymond.gymapp.model.SessionExercise;
import com.raymond.gymapp.repository.SessionExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionExerciseService {

    private final SessionExerciseRepository sessionExerciseRepository;

    public SessionExercise createSessionExercise(SessionExercise sessionExercise) {
        return sessionExerciseRepository.save(sessionExercise);
    }

    public SessionExercise getSessionExerciseById(Long id) {
        return sessionExerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("Session exercise not found"));
    }

    public List<SessionExercise> getAllSessionExercises() {
    return sessionExerciseRepository.findAll();
    }

    public void deleteSessionExercise(Long id) {
        sessionExerciseRepository.deleteById(id);
    }
}
