package gmu.edu.surveyformpage.service;

import java.util.List;

import gmu.edu.surveyformpage.model.SurveyEntity;

public interface SurveyService {
	SurveyEntity createSurvey(SurveyEntity surveyentity);
	List<SurveyEntity> getAllSurveys();
	SurveyEntity getSurveyById(Long id);
	SurveyEntity updateSurvey(Long id, SurveyEntity surveyUpdate);
	void deleteSurvey(long id);
}
