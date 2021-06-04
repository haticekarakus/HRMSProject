package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"veriler listelendi.");
	}

	@Override
	public Result Register(Employer employer,String confirmPassword) {
		if(employer.getCompanyName()==null || employer.getWebAddress()==null || employer.getEmail()==null
				|| employer.getPhoneNumber()==null || employer.getPassword()==null ) {
			return new ErrorResult("Kayıt başarısız tüm alanları doldurun.");
		}
		else if (!isValidEmail(employer.getEmail())) {
			return new ErrorResult("Geçersiz Email adresi tekrar deneyin.");
		}
		else if(!checkIfEmailExists(employer.getEmail())){
			return new ErrorResult("Kayıtlı email tekrar deneyin.");
		}
		else if (!employer.getPassword().equals(confirmPassword)) {
			return new ErrorResult("Parola doğrulaması yanlış tekrar girin.");
		}
		
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"Kayıt başarılı.");
	}
	
	private boolean checkIfEmailExists(String email) {
		if(this.employerDao.findByEmail(email)!=null) {
			return false;
		}
		return true;
	}
	
	public boolean isValidEmail(String email) {
		String emailRegex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{3}\\b";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
