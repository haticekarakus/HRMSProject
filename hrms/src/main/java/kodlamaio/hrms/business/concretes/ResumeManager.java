package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeWithCandidateDto;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private CoverLetterService coverLetterService;
	private SchoolService schoolService;
	private ExperienceService experienceService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, CoverLetterService coverLetterService, SchoolService schoolService,
			ExperienceService experienceService) {
		super();
		this.resumeDao = resumeDao;
		this.coverLetterService = coverLetterService;
		this.schoolService = schoolService;
		this.experienceService = experienceService;
	}

	@Override
	public Result add(Resume resume) {
		resume.setCreationDate(LocalDate.now());
		this.resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş Eklendi");
	}

	@Override
	public Result update(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş Güncellendi");
	}

	@Override
	public Result delete(Resume resume) {
		this.resumeDao.delete(resume);
		return new SuccessResult("Özgeçmiş Silindi");
	}	

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
	}

	@Override
	public DataResult<Resume> getByResumeId(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.getByResumeId(id));
	}

	@Override
	public DataResult<Resume> getByCandidateId(int candidateId) {
		return new SuccessDataResult<Resume>(this.resumeDao.getByCandidateId(candidateId));
	}

	@Override
	public DataResult<ResumeWithCandidateDto> getResumeDetailsByCandidateId(int candidateId) {
		Resume resume=getByCandidateId(candidateId).getData();
		ResumeWithCandidateDto resumeWithCandidateDto=new ResumeWithCandidateDto();
		resumeWithCandidateDto.setResumeId(resume.getResumeId());
		resumeWithCandidateDto.setCreationDate(resume.getCreationDate());
		resumeWithCandidateDto.setCandidate(resume.getCandidateId());
		resumeWithCandidateDto.setCoverLetter(resume.getCoverLetterId());
		resumeWithCandidateDto.setSchools(schoolService.getAllByResumeIdSortedByGraduationYearDesc(resume.getResumeId()).getData());
		resumeWithCandidateDto.setExperiences(experienceService.getAllByResumeIdSortedByEndDate(resume.getResumeId()).getData());
		resumeWithCandidateDto.setLanguages(resume.getLanguages());
		resumeWithCandidateDto.setLinks(resume.getLinks());
		resumeWithCandidateDto.setSkills(resume.getSkills());
		return new SuccessDataResult<ResumeWithCandidateDto>(resumeWithCandidateDto);
	}

	@Override
	public Result addCoverLetterToResume(int resumeId, int coverLetterId) {
		Resume resume=getByResumeId(resumeId).getData();
		resume.setCoverLetterId(coverLetterService.getByCoverLetterId(coverLetterId).getData());
		update(resume);
		return new SuccessResult("Ön yazı Özgeçmişe eklendi.");
	}

}
