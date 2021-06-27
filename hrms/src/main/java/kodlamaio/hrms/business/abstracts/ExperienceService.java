package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService extends BaseEntityService<Experience>{
	DataResult<Experience> getByExperienceID(int id);
	DataResult<List<Experience>> getAllByResumeId(int resumeId);
	DataResult<List<Experience>> getAllByResumeIdSortedByEndDate(int resumeId);	
}
