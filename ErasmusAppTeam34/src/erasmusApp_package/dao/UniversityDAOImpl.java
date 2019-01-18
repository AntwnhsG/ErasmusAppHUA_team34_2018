package erasmusApp_package.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import erasmusApp_package.entity.Student;
import erasmusApp_package.entity.University;

@Repository
public class UniversityDAOImpl implements UniversityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	// get all the universities from the database
	public List<University> getUniversities() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<University> query = currentSession.createQuery("from University", University.class);

		// execute the query and get the results list
		List<University> universities = query.getResultList();

		// return the results
		return universities;
	}

	@Override
	@Transactional
	// add a university to the database
	public String setUniversity(/* int univ_id, */String country, String city, String univ_name, int available_room) {
		University univ = new University();
		Session currentSession = sessionFactory.getCurrentSession();
		univ.setAvailable_room(available_room);
		univ.setCity(city);
		univ.setUniv_name(univ_name);
		univ.setCountry(country);
		currentSession.save(univ);
		String succ = "The information was succesfully added";
		return succ;
	}

	@Override
	@Transactional
	// get a selected university from the database
	public University getUniversity(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from University where university_id = :id", University.class);
		query.setParameter("id", id);
		University univ = (University) query.uniqueResult();
		return univ;

	}

	@Override
	@Transactional
	// update a row in the database
	public String updateUniversity(String columnName, String newValue, String id) {
		String succ;
		int univ_id = Integer.parseInt(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query query;
		String cName = columnName.toUpperCase();
		if (cName.equals("UNIVERSITY ID")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession
						.createQuery("update University set university_id = :new_id where university_id = :id");
				query.setParameter("new_id", nValue);
				query.setParameter("id", univ_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return succ = "failed";
			}
		} else if (cName.equals("NAME")) {
			query = currentSession.createQuery("update University set univ_name = :newName where university_id = :id");
			query.setParameter("newName", newValue);
			query.setParameter("id", univ_id);
			query.executeUpdate();
		} else if (cName.equals("COUNTRY")) {
			query = currentSession.createQuery("update University set country = :newCountry where university_id = :id");
			query.setParameter("newCountry", newValue);
			query.setParameter("id", univ_id);
			query.executeUpdate();
		} else if (cName.equals("CITY")) {
			query = currentSession.createQuery("update University set city = :newCity where university_id = :id");
			query.setParameter("newCity", newValue);
			query.setParameter("id", univ_id);
			query.executeUpdate();
		} else if (cName.equals("AVAILABLE ROOM")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession
						.createQuery("update University set available_room = :newAvRoom where university_id = :id");
				query.setParameter("newAvRoom", nValue);
				query.setParameter("id", univ_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return succ = "failed";
			}
		} else {
			return succ = "failed";
		}
		return succ = "Update was Successful";
	}

	@Override
	@Transactional
	// delete a university from the database
	public String deleteUniversity(String id) {
		String succ;
		Session currentSession = sessionFactory.getCurrentSession();
		int univ_id = Integer.parseInt(id);
		Query query = currentSession.createQuery("delete from University where university_id = :id");
		query.setParameter("id", univ_id);
		query.executeUpdate();
		return succ = "Delete Successful";
	}
}
