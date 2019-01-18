package erasmusApp_package.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import erasmusApp_package.entity.Secretary;
import erasmusApp_package.entity.Student;

@Repository
public class SecretaryDAOImpl implements SecretaryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public String deleteSecEmp(String id) {
		String succ = "";
		Session currentSession = sessionFactory.getCurrentSession();
		int sec_id = Integer.parseInt(id);
		Query query = currentSession.createQuery("delete from Secretary where sec_id = :id");
		query.setParameter("id", sec_id);
		query.executeUpdate();
		return succ = "Delete Successful";
	}

	@Override
	@Transactional
	public String addSecEmp(int sec_id, String firstName, String lastName, String username, String password,
			int enabled, String email) {
		String succ = "";
		Secretary secretary = new Secretary();
		secretary.setSec_id(sec_id);
		secretary.setFirstName(firstName);
		secretary.setLastName(lastName);
		secretary.setEmail(email);
		secretary.setUsername(username);
		secretary.setEnabled(enabled);
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(secretary);
		Query query = currentSession.createSQLQuery(
				"INSERT INTO `user` (username, password, enabled)" + "VALUES (:username, :password, :enabled)");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("enabled", enabled);
		query.executeUpdate();
		Query query2 = currentSession
				.createSQLQuery("INSERT INTO authorities (username, authority)" + "VALUES (:username, :authority)");
		query2.setParameter("username", username);
		String role = "ROLE_SECRETARY";
		query2.setParameter("authority", role);
		query2.executeUpdate();
		succ = "User submited successfully";
		return succ;
	}

	@Override
	@Transactional
	public String editSecEmp(String id, String columnName, String newValue) {
		String succ = "";
		int sec_id = Integer.parseInt(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query query;
		String cName = columnName.toUpperCase();
		if (cName.equals("ID")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession.createQuery("update Secretary set sec_id  = :new_id where sec_id = :id");
				query.setParameter("new_id", nValue);
				query.setParameter("id", sec_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else if (cName.equals("FIRST NAME")) {
			query = currentSession.createQuery("update Secretary set first_name = :newFName where sec_id = :id");
			query.setParameter("newFName", newValue);
			query.setParameter("id", sec_id);
			query.executeUpdate();
		} else if (cName.equals("LAST NAME")) {
			query = currentSession.createQuery("update Secretary set last_name = :newLname where sec_id = :id");
			query.setParameter("newLname", newValue);
			query.setParameter("id", sec_id);
			query.executeUpdate();
		} else if (cName.equals("USERNAME")) {
			query = currentSession.createQuery("update Secretary set username = :newUsername where sec_id = :id");
			query.setParameter("newUsername", newValue);
			query.setParameter("id", sec_id);
			query.executeUpdate();
		} else if (cName.equals("EMAIL")) {
			query = currentSession.createQuery("update Secretary set email = :newEmail where sec_id = :id");
			query.setParameter("newEmail", newValue);
			query.setParameter("id", sec_id);
			query.executeUpdate();
		} else if (cName.equals("ENABLED")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession.createQuery("update Secretary set enabled = :newEnabled where sec_id = :id");
				query.setParameter("newEnabled", nValue);
				query.setParameter("id", sec_id);
				query.executeUpdate();
				String username = getSecretaryUsername(id);
				Query query2 = currentSession.createSQLQuery(
						"update `user` set enabled = '" + nValue + "' where username = '" + username + "'");
				query2.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else {
			return succ = "failed";
		}
		return succ = "UpdateSuccessful";
	}

	@Override
	@Transactional
	public String changePassword(String id, String password) {
		String succ = "";
		String username = getSecretaryUsername(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createSQLQuery(
				"update `user` set `password` = '" + password + "' where  username = '" + username + "'");
		query.executeUpdate();
		return succ = "Password changed Successfully";
	}

	@Override
	@Transactional
	public String getSecretaryUsername(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createSQLQuery("select username from secretary where sec_id = '" + id + "'");
		String username = (String) query.uniqueResult();
		return username;
	}
	
}
