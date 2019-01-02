package erasmusApp_package.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import erasmusApp_package.entity.Student;
import erasmusApp_package.entity.University;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	/*
	@Override
	@Transactional
	public List<Application> getApplications() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Application> query = currentSession.createQuery("from Application", Application.class);

		// execute the query and get the results list
		List<Application> applications = query.getResultList();

		// return the results
		return applications;
	}
	*/
	
	@Override
	@Transactional
	public int getSID(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		//Query query = currentSession.createQuery("select student_id from Student where username = '" +username+ "' and user_password = '" +password+ "'");
		Query query = currentSession.createQuery("select student_id from Student  where username = '" + username+ "'");
		List<Integer> student_id = query.getResultList();
		return student_id.get(0).intValue();
	}
	
	@Override
	@Transactional
	//get username and password from DB to check the credentials
	//returns 1 if user exists or 0 otherwise
	public int checkCredentials(String givenUsername, String givenPassword) {

		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query query = currentSession.createQuery("select 1 from Student  where username = '" + givenUsername + "' and user_password = '" + givenPassword + "'");		
		// execute the query and get the results list
		List<Integer> successResult = query.getResultList();
		if (query.getResultList().isEmpty()) {
			successResult.add(0);
		}
		// return the results		
		return successResult.get(0).intValue();

	}
	
}
