package kodlamaio.hrms.core.concretes;



import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import mernis.FakeMernisService;

@Service
public class MernisCheckAdapter implements MernisCheckService{
	
	
	private FakeMernisService mernisService = new FakeMernisService();



	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		return this.mernisService.ValidateByPersonalInfo(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());
	}

}
