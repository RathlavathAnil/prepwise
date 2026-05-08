package com.anil.placementprep.controller;

import com.anil.placementprep.entity.Question;
import com.anil.placementprep.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor

public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }
    @GetMapping("/company/{company}")
public List<Question> getQuestionsByCompany(
        @PathVariable String company
) {
    return questionService.getQuestionsByCompany(company);
}

@GetMapping("/difficulty/{difficulty}")
public List<Question> getQuestionsByDifficulty(
        @PathVariable String difficulty
) {
    return questionService.getQuestionsByDifficulty(difficulty);
}

@GetMapping("/topic/{topic}")
public List<Question> getQuestionsByTopic(
        @PathVariable String topic
) {
    return questionService.getQuestionsByTopic(topic);
}

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        return questionService.deleteQuestion(id);
    }
}