package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
    DataResult<JobAdvertisement> getById(int id);
    Result add(JobAdvertisement jobAdvertisement);
    Result closeAdvertisement(int id);
    DataResult<List<JobAdvertisement>> getByIsActive();
    DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineDesc();
    DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(int id);

}
