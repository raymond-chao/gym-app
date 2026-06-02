package com.raymond.gymapp.service;


import com.raymond.gymapp.model.ExerciseSet;
import com.raymond.gymapp.repository.ExerciseSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseSetService {

    private final ExerciseSetRepository exerciseSetRepository;

    public ExerciseSet createExerciseSet(ExerciseSet exerciseSet) {

        return exerciseSetRepository.save(exerciseSet);
    }
    public ExerciseSet getExerciseSetById(Long id) {
        return exerciseSetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise set not found"));
    }
    public void deleteExerciseSet(Long id) {
        exerciseSetRepository.deleteById(id);
    }

    public List<ExerciseSet> getSetsBySessionExerciseId(Long sessionExerciseId) {
        return exerciseSetRepository.findBySessionExercise_Id(sessionExerciseId);
    }


}
