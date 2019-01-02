package erasmusApp_package.dao;

import erasmusApp_package.entity.Secretary;
// see secretaryDAOImpl
public interface SecretaryDAO {
	public int checkCredentials(String givenUsername, String givenPassword);

}
