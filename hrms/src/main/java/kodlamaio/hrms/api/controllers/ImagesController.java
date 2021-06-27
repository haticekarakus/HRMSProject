package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {
	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> upload(@ModelAttribute("photo") Image image,@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException{
		return new ResponseEntity<>(this.imageService.add(image, multipartFile), HttpStatus.OK);
	}
	
	@PostMapping("/photoUpdate")
	@Transactional
	public ResponseEntity<?> update(int resumeId, MultipartFile multipartFile) throws IOException{
		return new ResponseEntity<>(this.imageService.update(resumeId, multipartFile), HttpStatus.OK);
	}
	
	@DeleteMapping("/photoDelete")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException{
		return new ResponseEntity<>(this.imageService.delete(id), HttpStatus.OK);
	}


}
