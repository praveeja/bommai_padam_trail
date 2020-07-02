package in.bommaipadam.comic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	public Comic(String name, String genre, String imgSrc) {
		super();
		this.name = name;
		this.genre = genre;
		this.imgSrc = imgSrc;
		this.createdDate = LocalDate.now();
	}

	private String genre;

	private LocalDate createdDate;

	private String imgSrc;

}
