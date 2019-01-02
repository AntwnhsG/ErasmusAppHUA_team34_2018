package erasmusApp_package.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SecretaryDAOImpl implements SecretaryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	//get username and password from DB to check the credentials
	//returns 1 if user exists or 0 otherwise
	public int checkCredentials(String givenUsername, String givenPassword) {

		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query query = currentSession.createQuery("select 1 from Secretary  where username = '" + givenUsername
				+ "' and user_password = '" + givenPassword + "'");
		// execute the query and get the results list
		List<Integer> successResult = query.getResultList();
		if (query.getResultList().isEmpty()) {
			successResult.add(0);
		}
		// return the results
		return successResult.get(0).intValue();

	}
}
