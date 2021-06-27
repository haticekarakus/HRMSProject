package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	
	@Modifying
	@Query("update Image set url=:url where resumeId=:resumeId")
	int updateImageSetUrlForResumeId(@Param("url") String url,@Param("resumeId") int resumeId);
	
	@Query("Select resumeId From Image")
	List<Integer> getAllResumeId();}
