package com.raymond.gymapp.repository;

import com.raymond.gymapp.model.SessionExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionExerciseRepository extends JpaRepository<SessionExercise, Long> {
    List<SessionExercise> findBySessionId(Long sessionId);
}
