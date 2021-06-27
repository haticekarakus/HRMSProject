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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="schools")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	
	@NotNull
	@Column(name="school_name")
	private String schoolName;
	
	@NotNull
	@Column(name="department")
	private String department;
	
	@NotNull
	@Column(name="year_of_start")
	private LocalDate yearOfStart;
	
	@Column(name="graduation_year")
	private LocalDate graduationYear;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	@JsonIgnoreProperties("schools")
	private Resume resumeId;
	
	public String getGraduationYear() {

		if (graduationYear == null) {
			return "Devam ediyor.";
		}

		return graduationYear.toString();
	}

	
}
