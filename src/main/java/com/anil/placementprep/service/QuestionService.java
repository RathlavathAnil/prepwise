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
    public List<Question> getQuestionsByCompany(String company) {
    return questionRepository.findByCompany(company);
}

public List<Question> getQuestionsByDifficulty(String difficulty) {
    return questionRepository.findByDifficulty(difficulty);
}

public List<Question> getQuestionsByTopic(String topic) {
    return questionRepository.findByTopic(topic);
}
}