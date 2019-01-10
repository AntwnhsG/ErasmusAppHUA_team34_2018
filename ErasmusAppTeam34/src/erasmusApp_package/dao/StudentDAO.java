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

}
