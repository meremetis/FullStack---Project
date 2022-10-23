package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;

public interface ICourseService 
{
	/**
	 * Inserts a {@link Course} based on the data carried by the {@link CourseDTO}.
	 * 
	 * @param courseDTO
	 * 				DTO objects that contains the data.
	 * @throws SQLException
	 * 				If any error happens during SQL insert.
	 */
	void insertCourse(CourseDTO courseDTO) throws SQLException;
	
	
	
	
	
	/**
	 * Deletes a {@link Course} based on the data carried by the {@link CourseDTO}.
	 * 
	 * @param courseDTO
	 * 				DTO objects that contains the data.
	 * @throws SQLException
	 * 				If any error happens during SQL delete.
	 * @throws CourseNotFoundException
	 * 				If any course identified by their id, not found.
	 */
	void deleteCourse(CourseDTO courseDTO) throws SQLException, CourseNotFoundException;
	
	
	

	/**
	 * Updates a {@link Course} based on the data carried by the {@link newCourseDTO}
	 * identified by their is, carried by {@link oldCourseDTO}.
	 * 
	 * @param oldCourseDTO
	 * 				DTO objects that contains the data of the student to be updated
	 * @param newCourseDTO
	 * 				DTO objects that carried the data of the new student.
	 * @throws SQLException
	 * 				If any error happens during SQL update.
	 */
	void updateCourse(CourseDTO oldCourseDTO, CourseDTO newCourseDTO) throws SQLException;
	
	
	
	
	
	
	
	/**
	 * Gets back to the caller a list of the {@link Course} objects .
	 * 
	 * 
	 * @return
	 * 			a list that contains the results of the called method or empty list 
	 *			if results not found
	 * @throws SQLException
	 * 			if any error happens during the SQL search
	 */
	List<Course> getCourses() throws SQLException;
	
	
	
	/**
	 * Get back the course identified by their id.
	 * 
	 * @param id
	 * 			Course's id
	 * @return
	 * 			The course object, otherwise null if the course not found
	 * @throws SQLException
	 * 			if any error happens during SQL search.
	 * @throws CourseNotFoundException
	 * 			if not course found
	 */
	Course getCourseByid(int id) throws SQLException , CourseNotFoundException;
}
