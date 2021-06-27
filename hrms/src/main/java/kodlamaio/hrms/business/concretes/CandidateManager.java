package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private EmailSendService emailSendService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisCheckService mernisCheckService,EmailSendService emailSendService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisCheckService=mernisCheckService;
		this.emailSendService=emailSendService;
	}

	@Override
	public Result Register(Candidate candidate) {
		if(candidate.getFirstName()==null || candidate.getLastName()==null || candidate.getIdentityNumber()==null
				|| candidate.getEmail()==null || candidate.getBirthDate()==null || candidate.getPassword()==null) {
			return new ErrorResult("Kayıt başarısız tüm alanları doldurun.");
		}
		
		else if(!checkIfRealPerson(candidate)) {
			return new ErrorResult("Doğrulama geçersiz.");
		}
		
		else if(!checkIfEmailExists(candidate.getEmail(),candidate.getIdentityNumber())) {
			return new ErrorResult("Kayıtlı kimlik no veya email tekrar deneyin.");
		}
		
		this.emailSendService.emailSend();
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),"Kayıt olundu");
	}
	
	private boolean checkIfRealPerson(Candidate candidate) {
		if(!mernisCheckService.checkIfRealPerson(candidate)) {
			return false;
		}
		return true;
	}
	private boolean checkIfEmailExists(String email, String identityNumber) {
		if(this.candidateDao.findByEmail(email)!= null || this.candidateDao.findByIdentityNumber(identityNumber)!=null) {
			return false;
		}
		return true;
	}


	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"veriler listelendi.");
	}

	@Override
	public DataResult<Candidate> getByCandidateId(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByUserId(id));
	}


}
