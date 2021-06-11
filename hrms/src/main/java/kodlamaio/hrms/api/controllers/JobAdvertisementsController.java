package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
    	return this.jobAdvertisementService.add(jobAdvertisement);
    }

	@GetMapping("/getallactivejobadvertisement")
    public DataResult<List<JobAdvertisement>> getByIsActive(){
    	return this.jobAdvertisementService.getByIsActive();
    }
	
	@GetMapping("/findallbydate")
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineDesc(){
    	return this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineDesc();
    }
	
	@GetMapping("/getallactivejobadvertisementbyemployer")
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(@RequestParam("employer_id") int id){
    	return this.jobAdvertisementService.getByIsActiveTrueAndEmployerId(id);
    }
    
    
	@GetMapping("/closeadvertisement")
    public Result closeAdvertisement(@RequestParam int id) {
    	return this.jobAdvertisementService.closeAdvertisement(id);
    }



}
