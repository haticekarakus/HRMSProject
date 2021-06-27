package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul Bilgileri Eklendi.");
	}

	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul Bilgileri Güncellendi.");
	}

	@Override
	public Result delete(School school) {
		this.schoolDao.delete(school);
		return new SuccessResult("Okul Bilgileri Silindi.");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Veriler Listelendi"); 
	}

	@Override
	public DataResult<School> getBySchoolId(int id) {
		return new SuccessDataResult<School>(this.schoolDao.getBySchoolId(id));
	}

	@Override
	public DataResult<List<School>> getAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByResumeId(resumeId)); 
	}

	@Override
	public DataResult<List<School>> getAllByResumeIdSortedByGraduationYearDesc(int resumeId) {
		Sort sort=Sort.by(Sort.Direction.DESC,"graduationYear");
		return new SuccessDataResult<List<School>>(this.schoolDao.getByResumeId(resumeId,sort));
	}

	/*
	@Override
	public Result add(School school) {
		return new SuccessDataResult<School>(this.schoolDao.save(school),"Okul bilgisi başarıyla eklendi.");
	}

	@Override
	public Result delete(int id) {
		this.schoolDao.deleteById(id);
		return new SuccessResult("Okul bilgileri silindi.");
	}


	@Override
	public DataResult<School> getBySchoolId(int id) {
		return new SuccessDataResult<School>(this.schoolDao.getBySchoolId(id),"Veriler Listelendi");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Veriler Listelendi");
	}

	@Override
	public DataResult<List<School>> getAllByCandidateIdOrderByGraduationYearDesc(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCandidateIdOrderByGraduationYearDesc(id),"Veriler Listelendi");
	}

	@Override
	public DataResult<List<School>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCandidateId(id),"Veriler Listelendi");
	}
*/
}
