package entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Albums implements Serializable {

	private static final long serialVersionUID = 4607818484444629221L;
	@Id
	@Column(name = "album_id")
	private String id;
	private String title;
	private double price;
	@Column(name = "year_of_release")
	private int yearOfRelease;
	@Column(name = "download_link")
	private String dowloadLink;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	Genres genre;

	@ManyToMany
	@JoinTable(name = "albums_artists", joinColumns = {
			@JoinColumn(name = "album_id") }, inverseJoinColumns = @JoinColumn(name = "artist_id"))
	Set<Artists> artists;

	@ManyToMany
	@JoinTable(name = "albums_songs", joinColumns = { @JoinColumn(name = "album_id") }, inverseJoinColumns = {
			@JoinColumn(name = "song_id") })
	Set<Songs> songs;
}
