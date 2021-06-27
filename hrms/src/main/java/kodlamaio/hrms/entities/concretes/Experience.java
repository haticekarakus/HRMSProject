package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="experiences")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="experience_id")
	private int experienceId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	@JsonIgnoreProperties("experiences")
	private Resume resumeId;
	
	public String getEndDate() {

		if (endDate == null) {
			return "Devam ediyor.";
		}

		return endDate.toString();
	}
}
