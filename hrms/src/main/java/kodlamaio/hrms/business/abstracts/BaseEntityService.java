package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface BaseEntityService<T> {
	Result add(T entity);
	Result update(T entity);
	Result delete(T entity);
	DataResult<List<T>> getAll();
}
