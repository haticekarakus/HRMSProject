package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Experience experience) {
		return this.experienceService.add(experience);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Experience experience) {
		return this.experienceService.update(experience);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Experience experience) {
		return this.experienceService.delete(experience);
	}
	
	@GetMapping("/getallbyresumeid")
	public DataResult<List<Experience>> getAllByResumeId(@RequestParam int resumeId){
		return this.experienceService.getAllByResumeId(resumeId);
	}
	
	@GetMapping("/getallbyresumeidsortedbyenddate")
	public DataResult<List<Experience>> getAllByResumeIdSortedByEndDate(@RequestParam int resumeId){
		return this.experienceService.getAllByResumeIdSortedByEndDate(resumeId);
	}
	
	
}
