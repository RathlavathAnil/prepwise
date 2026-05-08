package com.anil.placementprep.repository;

import com.anil.placementprep.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCompany(String company);

    List<Question> findByDifficulty(String difficulty);

    List<Question> findByTopic(String topic);
}