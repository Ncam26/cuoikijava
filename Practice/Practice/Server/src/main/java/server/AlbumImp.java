package server;

import java.util.List;
import java.util.Map;

import entities.Albums;

public interface AlbumImp {
	boolean updatePriceOfAlbum(String id, double newPrice);
	List<Albums> listAlbumByGenre(String genreName);
	Map<String, Long> getNumberOfAlbumsByGenre();
}
