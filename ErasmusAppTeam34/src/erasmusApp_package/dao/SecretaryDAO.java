package erasmusApp_package.dao;

import erasmusApp_package.entity.Secretary;
// see secretaryDAOImpl
public interface SecretaryDAO {
	//public int checkCredentials(String givenUsername, String givenPassword);
	public String deleteSecEmp(String id);
	public String addSecEmp(int sec_id, String firstName, String lastName, String username, String password, int enabled, String email );
	public String editSecEmp(String id, String columnName, String newValue);
	public String changePassword(String id, String password);
	public String getSecretaryUsername(String id);
}
