package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;

import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;

public interface IStudentCourseService
{
	/**
	 * Inserts a {@link StudentCourse} based on the data carried by the {@link StudentCourseDTO}.
	 * 
	 * @param courseDTO
	 * 				DTO objects that contains the data.
	 * @throws SQLException
	 * 				If any error happens during SQL insert.
	 * @throws StudentCourseAlreadyExist
	 * 				If StudentCourse already exist.
	 */
	void insertStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException;
	
	
	
	
	
	/**
	 * Deletes a {@link StudentCourse} based on the data carried by the {@link studentCourseDTO}.
	 * 
	 * @param studentCourseDTO
	 * 				DTO objects that contains the data.
	 * @throws SQLException
	 * 				If any error happens during SQL delete.
	 * @throws CourseNotFoundException
	 * 				If any course identified by their student_id and course_id, not found.
	 */
	void deleteStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException, StudentCourseNotFoundException;
	
	
	

	/**
	 * Updates a {@link StudentCourse} based on the data carried by the {@link newstudentCourseDTO}
	 * identified by their is, carried by {@link oldstudentCourseDTO}.
	 * 
	 * @param oldstudentCourseDTO
	 * 				DTO objects that contains the data of the student to be updated
	 * @param newstudentCourseDTO
	 * 				DTO objects that carried the data of the new student.
	 * @throws SQLException
	 * 				If any error happens during SQL update.
	 */
	void updateStudentCourse(StudentCourseDTO oldstudentCourseDTO, StudentCourseDTO newstudentCourseDTO) throws SQLException;
	
	
	
	
	
	
	
	/**
	 * Gets back to the caller a list of the {@link StudentCourses} objects .
	 * 
	 * 
	 * @return
	 * 			a list that contains the results of the called method or empty list 
	 *			if results not found
	 * @throws SQLException
	 * 			if any error happens during the SQL search
	 */
	List<StudentCourse> getStudentCourses() throws SQLException;
	
	
	
	/**
	 * Get back the course identified by their id.
	 * 
	 * @param student_id
	 * 			StudentCourse's student_id
	 * @param course_id
	 * 			StudentCourse's course_id
	 * @return
	 * 			The course object, otherwise null if the course not found
	 * @throws SQLException
	 * 			if any error happens during SQL search.
	 * @throws StudentCourseNotFoundException
	 * 			if not course found
	 */
	StudentCourse getStudentCourseByids(int student_id, int course_id) throws SQLException , StudentCourseNotFoundException;
}
