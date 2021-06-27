package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name="images")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="image_id")
	private int imageId;
	
	@Column(name="url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	@JsonIgnoreProperties("resumes")
	private Resume resumeId;

}
