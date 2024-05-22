package course;

import java.util.List;
import java.util.Map;

import dao.Coursedao;
import entities.Course;
import entities.OnsiteCourse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class course implements Coursedao{
   private EntityManager entityManager;

public course(EntityManager entityManager) {
	   this.entityManager = entityManager;
   }
	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(course);
			trans.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			if(trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Course, Integer> countOnsiteCourse() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean updateCourse(int id ,String title) {
		// TODO Auto-generated method stub
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			Course course = entityManager.find(Course.class, id);
			course.setTitle(title);
			entityManager.merge(course);
			trans.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			if(trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
				return false;
	}
	@Override
	public boolean deleteCourse(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Course findCourseByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Course findCourseByTitle(String title) {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	public List<OnsiteCourse> findAllOnsiteCourses() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Course> findCourseByTitleLike(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
