package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Albums;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import server.AlbumImp;

public class AlbumDAO implements AlbumImp{

	private EntityManager entityManager;
	
	public AlbumDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
//	a
	@Override
	public boolean updatePriceOfAlbum(String id, double newPrice) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			Albums album = entityManager.find(Albums.class, id);
			album.setPrice(newPrice);
			entityManager.merge(album);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
//  b
	@Override
	public List<Albums> listAlbumByGenre(String genreName) {
		System.out.println("genreName=" + genreName);
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			List<Albums> results = entityManager.createNativeQuery("SELECT a.* FROM albums a JOIN genres g ON g.genre_id = a.genre_id WHERE g.name LIKE :genreName AND a.year_of_release = 1966", Albums.class)
					.setParameter("genreName", "%" + genreName + "%")
					.getResultList();
			trans.commit();
			return results;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Map<String, Long> getNumberOfAlbumsByGenre() {
		EntityTransaction trans = entityManager.getTransaction();
		Map<String, Long> groupedAlbums = new HashMap<>();
		
		try {
			trans.begin();
			
			List<Object[]> results = entityManager.createNativeQuery("SELECT g.name, COUNT(*) FROM albums a JOIN genres g ON a.genre_id = g.genre_id GROUP BY a.genre_id").getResultList();
			
			// Duyệt qua kết quả và xây dựng Map<String, Long>
	        for (Object[] result : results) {
	            String genreName = (String) result[0];
	            Long count = ((Number) result[1]).longValue();
	            groupedAlbums.put(genreName, count);
	        }
			
			System.out.println("groupedAlbums=" + groupedAlbums);
			
			trans.commit();
			
			return groupedAlbums;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

}
