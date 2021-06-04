package mernis;

import java.util.Date;

public class FakeMernisService {
	public boolean ValidateByPersonalInfo(String identityNumber , String firstName, String lastName , Date birthYear) {

		if( identityNumber.isEmpty() || firstName.isEmpty()  || lastName.isEmpty() || birthYear ==null) {
			return false;
		}
		return true;

	}
}
