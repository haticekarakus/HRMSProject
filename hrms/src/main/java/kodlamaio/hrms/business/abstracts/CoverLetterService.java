package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService extends BaseEntityService<CoverLetter>{
	DataResult<CoverLetter> getByCoverLetterId(int id);
}
