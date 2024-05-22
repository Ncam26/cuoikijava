package entities;


import java.io.Serializable;
import java.util.Set;

import org.hibernate.boot.model.source.spi.InheritanceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Genres implements Serializable{

	private static final long serialVersionUID = -6563674801930025594L;
	@Id
	@Column(name = "genre_id")
	private String id;
	private String name;
	private String description;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "genre")
	Set<Albums>albums;
}
