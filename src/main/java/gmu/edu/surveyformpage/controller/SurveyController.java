package gmu.edu.surveyformpage.controller;

import gmu.edu.surveyformpage.model.SurveyEntity;
import gmu.edu.surveyformpage.service.SurveyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("survey")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	
	// create or add new survey item in the database using POST
	@PostMapping("create")
	public ResponseEntity<SurveyEntity> createSurvey(@RequestBody SurveyEntity surveyentity) {
		return new ResponseEntity<SurveyEntity>(surveyService.createSurvey(surveyentity), HttpStatus.CREATED);
	}
	
	// Display all surveys stored in the Survey table
	@GetMapping
	public List<SurveyEntity> getAllSurveys() {
		return surveyService.getAllSurveys();
	}
	
	// Get a survey item by using the id
	@GetMapping("{id}")
	public ResponseEntity<SurveyEntity> getSurveyById(@PathVariable("id") long id) {
		return new ResponseEntity<SurveyEntity>(surveyService.getSurveyById(id), HttpStatus.OK);
	}
	
	// update existing survey
	@PutMapping("update/{id}")
	public ResponseEntity<SurveyEntity> updateSurvey(@PathVariable("id") long id, @RequestBody SurveyEntity surveyUpdate) {
		SurveyEntity updateSurvey = surveyService.updateSurvey(id, surveyUpdate);
		return new ResponseEntity<SurveyEntity>(updateSurvey, HttpStatus.OK);
	}
	
	// delete survey from the database
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteSurvey(@PathVariable("id") long id) {
		surveyService.deleteSurvey(id);
		return new ResponseEntity<String>("Employee deleted Successfully.", HttpStatus.OK);
	}
}
