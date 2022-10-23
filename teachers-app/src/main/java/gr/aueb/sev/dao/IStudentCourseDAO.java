package gr.aueb.sev.dao;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.model.Teacher;

public interface IStudentCourseDAO 
{
	void insert(StudentCourse studentCourse) throws SQLException;
	StudentCourse delete(StudentCourse studentCourse) throws SQLException;
	void update(StudentCourse oldStudentCourse, StudentCourse newStudentCourse) throws SQLException;
	List<StudentCourse> getAllStudentCourse()throws SQLException;
	StudentCourse getStudentCourseById(int student_id, int course_id) throws SQLException;
}
