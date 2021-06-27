package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody School school) {
		return this.schoolService.delete(school);
	}
	/*
	@GetMapping("/getbyid")
	public DataResult<School> getBySchoolId(int id){
		return this.schoolService.getBySchoolId(id);
	}
	*/
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/getallbyresumeidsortedbygraduationyear")
	public DataResult<List<School>> getAllByResumeIdSortedByGraduationYearDesc(@RequestParam int resumeId){
		return this.schoolService.getAllByResumeIdSortedByGraduationYearDesc(resumeId);
	}
	
	@GetMapping("/getallbycandidateid")
	public DataResult<List<School>> getAllByResumeId(@RequestParam int resumeId){
		return this.schoolService.getAllByResumeId(resumeId);
	}
}