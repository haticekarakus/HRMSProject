package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Link;

public interface LinkService extends BaseEntityService<Link>{
	DataResult<Link> getByLinkId(int id);
}
