package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeWithCandidateDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		return resumeService.add(resume);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Resume resume) {
		return resumeService.update(resume);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Resume resume) {
		return resumeService.delete(resume);
	}

	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll() {
		return resumeService.getAll();
	}

	@GetMapping("/getbyresumeid")
	public DataResult<Resume> getByResumeId(@RequestParam int id) {
		return resumeService.getByResumeId(id);
	}

	@PostMapping("/addcoverlettertoresume")
	public Result addCoverLetterToResume(int resumeId, int coverLetterId) {
		return resumeService.addCoverLetterToResume(resumeId, coverLetterId);
	}

	@GetMapping("/getresumedetailsbycandidateid")
	public DataResult<ResumeWithCandidateDto> getResumeDetailsByCandidateId(int candidateId) {
		return resumeService.getResumeDetailsByCandidateId(candidateId);
	}
}
