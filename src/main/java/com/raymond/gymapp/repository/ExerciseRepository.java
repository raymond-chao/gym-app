package com.raymond.gymapp.repository;

import com.raymond.gymapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
