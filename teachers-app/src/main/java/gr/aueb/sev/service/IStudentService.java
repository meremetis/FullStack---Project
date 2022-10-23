package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

public interface IStudentService
{
	/**
	 * Inserts a {@link Student} based on the data carried by the {@link StudentDTO}.
	 * 
	 * @param studentDTO
	 * 				DTO objects that contains the data.
	 * @throws SQLException
	 * 				If any error happens during SQL insert.
	 */
	void insertStudent(StudentDTO studentDTO) throws SQLException;
	
	
	
	
	
	/**
	 * Deletes a {@link Student} based on the data carried by the {@link StudentDTO}.
	 * 
	 * @param studentDTO
	 * 				DTO objects that contains the data.
	 * @throws SQLException
	 * 				If any error happens during SQL delete.
	 * @throws StudentNotFoundException
	 * 				If any student identified by their id, not found.
	 */
	void deleteStudent(StudentDTO studentDTO) throws SQLException, StudentNotFoundException;
	
	
	

	/**
	 * Updates a {@link Student} based on the data carried by the {@link newStudentDTO}
	 * identified by their is, carried by {@link oldStudentDTO}.
	 * 
	 * @param oldStudentDTO
	 * 				DTO objects that contains the data of the student to be updated
	 * @param newStudentDTO
	 * 				DTO objects that carried the data of the new student.
	 * @throws SQLException
	 * 				If any error happens during SQL update.
	 */
	void updateStudent(StudentDTO oldStudentDTO, StudentDTO newStudentDTO) throws SQLException;
	
	
	
	
	
	
	
	/**
	 * Gets back to the caller a list of the {@link Student} objects identified
	 * by their last name.
	 * 
	 * @param lastname
	 * 			a string object that contains the initial letters of students's last name.
	 * @return
	 * 			a list that contains the results of the called method or empty list 
	 *			if results not found
	 * @throws SQLException
	 * 			if any error happens during the SQL search
	 */
	List<Student> getStudentByLastname(String lastname) throws SQLException;
	
	
	
	/**
	 * Get back the student identified by their id.
	 * 
	 * @param id
	 * 			Student's id
	 * @return
	 * 			The student object, otherwise null if the student not found
	 * @throws SQLException
	 * 			if any error happens during SQL search.
	 * @throws TeacherNotFoundException
	 * 			if not student found
	 */
	Student getStudentByid(int id) throws SQLException , StudentNotFoundException;
}
