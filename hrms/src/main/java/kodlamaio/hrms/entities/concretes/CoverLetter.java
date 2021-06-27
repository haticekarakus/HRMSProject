package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cover_letters")
public class CoverLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="cover_letter_id")
	private int coverLetterId;
	
	@Column(name="content")
	private String content;

}
