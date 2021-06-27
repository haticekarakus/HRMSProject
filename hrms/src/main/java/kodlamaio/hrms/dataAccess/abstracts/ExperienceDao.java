package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{
	Experience getByExperienceId(int id);
	List<Experience> getByResumeId(int resumeId);
	List<Experience> getByResumeId(int resumeId, Sort sort);
}
