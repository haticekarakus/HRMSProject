package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	School getBySchoolId(int id);
	List<School> getByResumeId(int resumeId);
	List<School> getByResumeId(int resumeId, Sort sort);
	
	/*
	School getBySchoolId(int id);
	
	@Query("From School where candidate_id=:id Order By graduationYear desc")
	List<School> getAllByCandidateIdOrderByGraduationYearDesc(int id);
	
	@Query("From School where candidate_id=:id")
	List<School> getAllByCandidateId(int id);
	*/
}
