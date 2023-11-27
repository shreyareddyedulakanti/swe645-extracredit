package gmu.edu.surveyformpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gmu.edu.surveyformpage.model.SurveyEntity;

public interface SurveyRepository extends JpaRepository<SurveyEntity, Long> {

}
