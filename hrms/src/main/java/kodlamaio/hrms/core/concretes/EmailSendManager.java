package kodlamaio.hrms.core.concretes;



import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmailSendService;

@Service
public class EmailSendManager implements EmailSendService{

	@Override
	public void emailSend() {
		System.out.println("Email gönderildi. Kayıt başarılı.");
	}

}
