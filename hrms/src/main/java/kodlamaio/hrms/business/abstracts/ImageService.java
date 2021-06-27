package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	public Result add(Image image, MultipartFile multipartFile) throws IOException;	
	public Result update(int resumeId, MultipartFile multipartFile) throws IOException;
	public Result delete(String id) throws IOException;
}
