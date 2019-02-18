package erasmusApp_package.dao;

import java.util.List;

import erasmusApp_package.entity.Application;

public interface ApplicationDAO {
	public String submitApplication(String sFirstName, String sLastName, String sEmail, int sID, int uID, String KTL);
	public List<Application> showMyApplications(int sID);
	public String deleteApp(String id, String stud_id);
	public String editApplication(String id, String columnName, String newValue);
	public List<Integer> getUniv_ids(int id);
	public String checkUnivDuplication(int univ_id, List<Integer> univ_ids);
	//public List<Application> getAllApps();
	public String setAppStatus(String status, int appID);
}
