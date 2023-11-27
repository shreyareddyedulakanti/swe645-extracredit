package gmu.edu.surveyformpage.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmu.edu.surveyformpage.service.SurveyService;
import gmu.edu.surveyformpage.repository.SurveyRepository;
import gmu.edu.surveyformpage.exception.NotFoundException;
import gmu.edu.surveyformpage.model.SurveyEntity;

@Service
public class SurveyImpl implements SurveyService {
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Override
	public SurveyEntity createSurvey(SurveyEntity surveyentity) {
		return surveyRepository.save(surveyentity);
	}
	
	@Override
	public List<SurveyEntity> getAllSurveys() {
		return surveyRepository.findAll();
	}
	
	@Override
	public SurveyEntity getSurveyById(Long id) {
		Optional<SurveyEntity> surveyentity = surveyRepository.findById(id);
		
		if(surveyentity.isPresent()) {
			return surveyentity.get();
		} else {
			throw new NotFoundException("Survey", "Id", id);
		}		
	}

	@Override
	public SurveyEntity updateSurvey(Long id, SurveyEntity surveyUpdate) {
		surveyRepository.findById(id).orElseThrow(() -> new NotFoundException("Survey", "Id", id));
		surveyUpdate.setId(id);
		return surveyRepository.save(surveyUpdate);
	}
	
	@Override
	public void deleteSurvey(long id) {
		surveyRepository.findById(id).orElseThrow(() -> new NotFoundException("Survey", "Id", id));
		surveyRepository.deleteById(id);
	}
}
