package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService extends BaseEntityService<School>{
	DataResult<School> getBySchoolId(int id);
	DataResult<List<School>> getAllByResumeId(int resumeId);
	DataResult<List<School>> getAllByResumeIdSortedByGraduationYearDesc(int resumeId);
}
