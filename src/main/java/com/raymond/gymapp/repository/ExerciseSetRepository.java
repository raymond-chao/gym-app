package com.raymond.gymapp.repository;

import com.raymond.gymapp.model.ExerciseSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {
    List<ExerciseSet> findBySessionExerciseId(Long sessionExerciseId);
}
