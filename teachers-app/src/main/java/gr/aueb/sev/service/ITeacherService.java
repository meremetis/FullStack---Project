package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public interface ITeacherService {
	/**
	 * Inserts a {@link Teacher} based on the data carried by the {@link TeacherDTO}.
	 * 
	 * @param teacherDTO
	 * 				DTO objects that contains the data.
	 * @throws SQLException
	 * 				If any error happens during SQL insert.
	 */
	void insertTeacher(TeacherDTO teacherDTO) throws SQLException;
	
	
	
	
	
	/**
	 * Deletes a {@link Teacher} based on the data carried by the {@link TeacherDTO}.
	 * 
	 * @param teacherDTO
	 * 				DTO objects that contains the data.
	 * @throws SQLException
	 * 				If any error happens during SQL delete.
	 * @throws TeacherNotFoundException
	 * 				If any teacher identified by their id, not found.
	 */
	void deleteTeacher(TeacherDTO teacherDTO) throws SQLException, TeacherNotFoundException;
	
	
	

	/**
	 * Updates a {@link Teacher} based on the data carried by the {@link newTeacherDTO}
	 * identified by their is, carried by {@link oldTeacherDTO}.
	 * 
	 * @param oldTeacherDTO
	 * 				DTO objects that contains the data of the teacher to be updated
	 * @param newTeacherDTO
	 * 				DTO objects that carried the data of the new teacher.
	 * @throws SQLException
	 * 				If any error happens during SQL update.
	 */
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws SQLException;
	
	
	
	
	
	
	
	/**
	 * Gets back to the caller a list of the {@link Teacher} objects identified
	 * by their last name.
	 * 
	 * @param lastname
	 * 			a string object that contains the initial letters of teacher's last name.
	 * @return
	 * 			a list that contains the results of the called method or empty list 
	 *			if results not found
	 * @throws SQLException
	 * 			if any error happens during the SQL search
	 */
	List<Teacher> getTeachersByLastname(String lastname) throws SQLException;
	
	
	
	/**
	 * Get back the teacher identified by their id.
	 * 
	 * @param id
	 * 			Teacher's id
	 * @return
	 * 			The teacher object, otherwise null if the teacher not found
	 * @throws SQLException
	 * 			if any error happens during SQL search.
	 * @throws TeacherNotFoundException
	 * 			if not teacher found
	 */
	Teacher getTeacherByid(int id) throws SQLException , TeacherNotFoundException;
}
