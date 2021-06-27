package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeWithCandidateDto;

public interface ResumeService extends BaseEntityService<Resume>{
	DataResult<Resume> getByResumeId(int id);
	DataResult<Resume> getByCandidateId(int candidateId);
	DataResult<ResumeWithCandidateDto> getResumeDetailsByCandidateId(int candidateId);
	Result addCoverLetterToResume(int resumeId, int coverLetterId);
}
