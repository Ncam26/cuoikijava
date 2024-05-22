package entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Artists implements Serializable {

	private static final long serialVersionUID = -152269388788828458L;
	@Id
	@Column(name = "artist_id")
	private String id;
	private String name;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	private String url;

}
