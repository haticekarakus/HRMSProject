package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="resumes")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="resume_id")
	private int resumeId;
	
	@Column(name="creation_date")
	private LocalDate creationDate;
	
	@OneToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidateId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resumeId")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resumeId")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resumeId")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resumeId")
	private List<Link> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resumeId")
	private List<Skill> skills;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "cover_letter_id")
	private CoverLetter coverLetterId;
	
	@JsonIgnoreProperties("resumes")
	@OneToMany(mappedBy = "resumeId")
	private List<Image> images;
}
