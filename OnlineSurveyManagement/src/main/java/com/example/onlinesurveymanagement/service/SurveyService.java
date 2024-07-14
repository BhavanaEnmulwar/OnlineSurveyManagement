package com.example.onlinesurveymanagement.service;

import com.example.onlinesurveymanagement.model.Survey;
import com.example.onlinesurveymanagement.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Optional<Survey> getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }
 // Method to update an existing survey
    public Survey updateSurvey(Long id, Survey surveyDetails) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey not found with id " + id));

        survey.setTitle(surveyDetails.getTitle());
        // Update other fields as needed

        return surveyRepository.save(survey);
    }
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
 
    
}
