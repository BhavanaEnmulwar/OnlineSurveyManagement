package com.example.onlinesurveymanagement.controller;

import com.example.onlinesurveymanagement.model.Survey;
import com.example.onlinesurveymanagement.service.SurveyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        Optional<Survey> optionalSurvey = surveyService.getSurveyById(id);
        if (optionalSurvey.isPresent()) {
            return ResponseEntity.ok(optionalSurvey.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
