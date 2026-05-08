package com.anil.placementprep.service;

import com.anil.placementprep.entity.Question;
import com.anil.placementprep.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public String deleteQuestion(Long id) {
        questionRepository.deleteById(id);
        return "Question deleted successfully";
    }
}