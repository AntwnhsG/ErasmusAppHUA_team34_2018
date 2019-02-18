package erasmusApp_package.dao;

import java.util.ArrayList;
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
		app.setLanguageOption(KTL);
		app.setIsApproved("PENDING");
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
		Query<Application> query = currentSession.createQuery("from Application where stud_id = '" + sID + "'",
				Application.class);

		// execute the query and get the results list
		List<Application> applications = query.getResultList();

		// return the results
		return applications;
	}

	@Override
	@Transactional
	public String deleteApp(String id, String stud_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		int app_id = Integer.parseInt(id);
		int student_id = Integer.parseInt(stud_id);
		Query query = currentSession.createQuery("delete from Application where app_id ='" + app_id + "'");
		query.executeUpdate();
		Query query2 = currentSession.createSQLQuery("select num_of_apps from student where student_id = '" +student_id+ "'");
		int num_of_apps = (int)query2.uniqueResult();
		num_of_apps = num_of_apps -1;
		Query query3 = currentSession.createQuery("update Student set num_of_apps ='"+num_of_apps+"'");
		query3.executeUpdate();
		String message = "Application Deleted Successfully";
		return message;
	}

	@Override
	@Transactional
	public String editApplication(String id, String columnName, String newValue) {
		String message = "";
		int app_id = Integer.parseInt(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query query;
		String cName = columnName.toUpperCase();
		if (cName.equals("ID")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession.createQuery("update Application set app_id = :new_id where app_id = :id");
				query.setParameter("new_id", nValue);
				query.setParameter("id", app_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else if (cName.equals("FIRST NAME")) {
			query = currentSession.createQuery("update Application set first_name = :newFName where app_id = :id");
			query.setParameter("newFName", newValue);
			query.setParameter("id", app_id);
			query.executeUpdate();
		} else if (cName.equals("LAST NAME")) {
			query = currentSession.createQuery("update Application set last_name = :newLname where app_id = :id");
			query.setParameter("newLname", newValue);
			query.setParameter("id", app_id);
			query.executeUpdate();
		} else if (cName.equals("EMAIL")) {
			query = currentSession.createQuery("update Application set email = :newEmail where app_id = :id");
			query.setParameter("newEmail", newValue);
			query.setParameter("id", app_id);
			query.executeUpdate();
		} else if (cName.equals("STUDENT ID")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession.createQuery("update Application set stud_id = :newSID where app_id = :id");
				query.setParameter("newSID", nValue);
				query.setParameter("id", app_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else if (cName.equals("APPROVED")) {
			query = currentSession.createQuery("update Application set isApproved = :status where app_id = :id");
			query.setParameter("status", newValue.toUpperCase());
			query.setParameter("id", app_id);
			query.executeUpdate();
		} else if (cName.equals("UNIVERSITY ID")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession.createQuery("update Application set univ_id = :newUnivId where app_id = :id");
				query.setParameter("newUnivId", nValue);
				query.setParameter("id", app_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else {
			return message = "failed";
		}
		message = "Update was Successful";
		return message;
	}

	@Override
	@Transactional
	public List<Integer> getUniv_ids(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Integer> univ_ids = new ArrayList<Integer>();
		Query query = currentSession.createQuery("select univ_id from Application where stud_id = '"+id+"'");
		if(query.getResultList().isEmpty()) {
			univ_ids.add(99999);
			return univ_ids;
		}
			 univ_ids = query.getResultList();		
		return univ_ids;
	}
	
	@Override
	@Transactional
	public String checkUnivDuplication(int univ_id, List<Integer> univ_ids) {
		String message = "success";
		for(int i = 0; i == univ_ids.size(); i++) {
			
			if(univ_id == univ_ids.get(i)) {
				
				message = "failed";
			}
		}
		return message;
	}
/*
	@Override
	@Transactional
	public List<Application> getAllApps() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Application");
		List<Application> apps = query.getResultList();
		return apps;
		
	}
	*/
	@Override
	@Transactional
	public String setAppStatus(String status, int appID) {
		String message;
		Session currentSession = sessionFactory.getCurrentSession();	
			Query query = currentSession.createQuery("update Application set isApproved = '"+status+"' where app_id ='"+appID+"'");
			query.executeUpdate();
		return message = "Status changed successfully";
	}

}
