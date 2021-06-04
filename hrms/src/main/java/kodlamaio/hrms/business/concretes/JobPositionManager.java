package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionDao.findAll();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(!checkIfPositionExists(jobPosition.getPositionName())) {
			return new ErrorResult("Mevcut iş pozisyonu lütfen yeni bir pozisyon giriniz.");
		}
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.save(jobPosition),"Ekleme Başarılı");
	}
	
	private boolean checkIfPositionExists(String positionName) {
		if(this.jobPositionDao.findByPositionName(positionName)!=null) {
			return false;
		}
		return true;
	}

}
