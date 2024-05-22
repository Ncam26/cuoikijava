package services;

import java.util.List;
import java.util.Map;

import dao.Coursedao;
import entities.Course;
import entities.OnsiteCourse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CourseService implements Coursedao {

	private EntityManager entityManager;

	public CourseService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public boolean addCourse(Course course) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(course);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCourse(Course course) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.merge(course);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCourse(int id) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			Course course = entityManager.find(Course.class, id);
			entityManager.remove(course);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Course findCourseByID(int id) {
		return entityManager.find(Course.class, id);
	}

	@Override
	public Course findCourseByTitle(String title) {
		return entityManager.createQuery("SELECT c FROM Course c WHERE c.title = :title", Course.class)
				.setParameter("title", title)
				.getSingleResult();
		
//		return entityManager.createQuery("SELECT c FROM Course c WHERE c.title = :title", Course.class)
//				.setParameter("title", title)
//				.getResultList()
//				.stream()
//				.findFirst()
//				.orElse(null);
	}

	@Override
	public List<Course> findCourseByTitleLike(String title) {
		return entityManager.createNamedQuery("Course.findByTitleLike", Course.class)
				.setParameter("title", "%" + title + "%")
				.getResultList();
	}

	@Override
	public List<Course> findAll() {
		return entityManager.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	@Override
	public List<OnsiteCourse> findAllOnsiteCourses() {
		return entityManager.createNamedQuery("Course.findOnsiteCourses", OnsiteCourse.class).getResultList();
	}

	@Override
	public boolean updateCourse(int id, String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Course, Integer> countOnsiteCourse() {
		// TODO Auto-generated method stub
		return null;
	}

}
