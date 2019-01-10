package erasmusApp_package.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import erasmusApp_package.entity.Application;
import erasmusApp_package.entity.University;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public String submitApplication(String sFirstName, String sLastName, String sEmail, int sID, int uID, String KTL) {
		Application app = new Application();
		Session currentSession = sessionFactory.getCurrentSession();
		app.setStud_firstName(sFirstName);
		app.setStud_lastName(sLastName);
		app.setStud_email(sEmail);
		app.setStud_id(sID);
		app.setUniv_id(uID);
		app.setLanguageOption(KTL);app.setIsApproved("PENDING");
		currentSession.save(app);
		String succ = "Application Submitted Successfuly";
		return succ;
	}
	
	@Override
	@Transactional
	public List<Application> showMyApplications(int sID) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Application> query = currentSession.createQuery("from Application where stud_id = '"+sID+"'", Application.class);

		// execute the query and get the results list
		List<Application> applications = query.getResultList();

		// return the results
		return applications;
	}
	
}
