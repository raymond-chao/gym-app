package com.raymond.gymapp.service;

import com.raymond.gymapp.model.WorkoutSession;
import com.raymond.gymapp.repository.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutSessionService {

    private final WorkoutSessionRepository workoutSessionRepository;

    public List<WorkoutSession> getSessionsByUser(Long userId) {
        return workoutSessionRepository.findByUserId(userId);
    }
    public WorkoutSession createSession(WorkoutSession workoutSession) {
        return workoutSessionRepository.save(workoutSession);
    }

    public WorkoutSession getSessionById(Long id) {
        return workoutSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    public void deleteSession(Long id) {
        workoutSessionRepository.deleteById(id);
    }
}
