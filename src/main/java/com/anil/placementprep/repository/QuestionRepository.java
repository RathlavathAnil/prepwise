package com.anil.placementprep.repository;

import com.anil.placementprep.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}