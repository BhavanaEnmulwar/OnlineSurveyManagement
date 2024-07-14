package com.example.onlinesurveymanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinesurveymanagement.model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    Survey findByTitle(String title);

    List<Survey> findByUserId(Long userId);

    List<Survey> findByTitleContaining(String keyword);

    List<Survey> findByCreatedDateAfter(Date date);

    List<Survey> findByCreatedDateBetween(Date startDate, Date endDate);

    Long countByUserId(Long userId);

    void deleteByTitle(String title);

}
