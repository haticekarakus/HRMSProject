package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Skill;

public interface SkillService extends BaseEntityService<Skill>{
	DataResult<Skill> getBySkillId(int id);
}
