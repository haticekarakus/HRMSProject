package kodlamaio.hrms.entities.dtos;

import java.awt.Image;
import java.time.LocalDate;
import java.util.List;


import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeWithCandidateDto {
	private int resumeId;
	private LocalDate creationDate;
	private Candidate candidate;
	private CoverLetter coverLetter;
	private Image image;
	private List<School> schools;
	private List<Experience> experiences;
	private List<Language> languages;
	private List<Skill> skills;
	private List<Link> links;
}
