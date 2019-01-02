package erasmusApp_package.dao;

import java.util.List;

import erasmusApp_package.entity.Application;

public interface ApplicationDAO {
	public String submitApplication(String sFirstName, String sLastName, String sEmail, int sID, int uID, String KTL);
	public List<Application> showMyApplications(int sID);
}
