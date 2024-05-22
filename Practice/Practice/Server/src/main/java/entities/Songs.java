package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Songs implements Serializable{

	private static final long serialVersionUID = -8793015881984002212L;
	@Id
	@Column(name = "song_id")
	private String id;
	private String name;
	private String runtime;
	private String lyric;
	private String file_link;
}
