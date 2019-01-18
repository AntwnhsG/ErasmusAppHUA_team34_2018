package erasmusApp_package.dao;

import java.util.List;

import erasmusApp_package.entity.Student;
//see StudentDAOImpl
public interface StudentDAO {
	//public List<Application> getApplications();
	//public int checkCredentials(String givenUsername, String givenPassword);
	public int getSID(String username);
	public Student getStudInfo(int id);
	public void setNumOfApps(int id);
	public String deleteStudents(String id);
	public String addStudents(int student_id, String username, String password, int enabled, String firstName, String lastName, String email,
			int current_semester, int num_not_passed_courses);
	public String editStudents(String id, String columnName, String newValue);
	public String changePassword(String id, String password);
	public String getStudentUsername(String id);
	
}
