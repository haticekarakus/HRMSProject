package kodlamaio.hrms.business.concretes;

import java.io.IOException;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Image image, MultipartFile multipartFile) throws IOException {
		Result result= new ErrorResult("Fotoğraf Eklenemedi!");
		Map photoMap = cloudinaryService.photoUpload(multipartFile);
		image.setUrl(photoMap.get("url").toString());
		if(!this.imageDao.getAllResumeId().contains(image.getResumeId().getResumeId())) {
			result = new SuccessResult("Fotoğraf Eklendi");
			this.imageDao.save(image);
		}
		return result;
	}
	@Override
	public Result delete(String id) throws IOException {
		this.cloudinaryService.photoDelete(id);
		return new SuccessResult("Fotoğraf Silindi");
	}

	@Override
	public Result update(int cvId, MultipartFile multipartFile) throws IOException {
		Map photoMap = cloudinaryService.photoUpload(multipartFile);
		this.imageDao.updateImageSetUrlForResumeId(photoMap.get("url").toString(), cvId);
		return new SuccessResult("Fotoğraf Güncellendi");
	}



}
