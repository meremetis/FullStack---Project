package gr.aueb.sev.service.exceptions;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;

public class CourseNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public CourseNotFoundException(Course course) 
	{
		super("Course with id = " + course.getId() + " was not found");
	}
}
