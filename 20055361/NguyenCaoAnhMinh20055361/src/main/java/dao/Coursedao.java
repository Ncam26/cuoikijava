package dao;

import java.util.List;
import java.util.Map;

import entities.Course;
import entities.OnsiteCourse;

public interface Coursedao {
 public boolean addCourse(Course course);
 public boolean updateCourse(int id,String title);
 public boolean deleteCourse(int id);
 public List<Course> findAll();
 public Map<Course, Integer> countOnsiteCourse();
	public Course findCourseByID(int id);
	public Course findCourseByTitle(String title);
	public List<OnsiteCourse> findAllOnsiteCourses();
	boolean updateCourse(Course course);
	List<Course> findCourseByTitleLike(String title);

}
