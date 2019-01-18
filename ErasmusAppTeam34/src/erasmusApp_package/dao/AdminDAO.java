package erasmusApp_package.dao;

import java.util.List;

import erasmusApp_package.entity.Secretary;
import erasmusApp_package.entity.Student;

public interface AdminDAO {
	
	public List<Student> getStudents();
	public List<Secretary> getSecEmployees();
}
