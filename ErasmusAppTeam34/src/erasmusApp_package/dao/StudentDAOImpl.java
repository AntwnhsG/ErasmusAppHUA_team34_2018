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

	@Override
	@Transactional
	public int getSID(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("select student_id from Student  where username = '" + username + "'");
		int student_id = (int) query.uniqueResult();
		return student_id;
	}

	@Override
	@Transactional
	public Student getStudInfo(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Student where student_id = '" + id + "'");
		Student student = (Student) query.uniqueResult();
		return student;
	}

	@Override
	@Transactional
	public void setNumOfApps(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = getStudInfo(id);
		int numOfApps = student.getNumOfApps() + 1;
		Query query = currentSession.createQuery(
				"update Student set num_of_apps = '" + numOfApps + "'" + "where student_id = '" + id + "'");
		query.executeUpdate();

	}

	@Override
	@Transactional
	public String deleteStudents(String id) {
		String succ = "";
		Session currentSession = sessionFactory.getCurrentSession();
		int stud_id = Integer.parseInt(id);
		String username = getStudentUsername(id);
		Query query = currentSession.createQuery("from Student where student_id = :id");
		query.setParameter("id", stud_id);
		Student student = (Student) query.uniqueResult();
		currentSession.delete(student);
		Query query3 = currentSession.createSQLQuery("delete from authorities where username = '" + username + "'");
		query3.executeUpdate();
		Query query2 = currentSession.createSQLQuery("delete from `user` where username = '" + username + "'");
		query2.executeUpdate();
		// Query query = currentSession.createQuery("delete from Student where id =
		// :id");
		// query.setParameter("id", stud_id);
		// query.executeUpdate();
		return succ = "Delete Successful";
	}

	@Override
	@Transactional
	public String addStudents(int student_id, String username, String password, int enabled, String firstName,
			String lastName, String email, int current_semester, int num_not_passed_courses) {
		String succ = "";
		Student student = new Student();
		student.setStudent_id(student_id);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setNumOfApps(0);
		student.setCurrent_semester(current_semester);
		student.setNum_not_passed_courses(num_not_passed_courses);
		student.setUsername(username);
		student.setEnabled(enabled);
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createSQLQuery(
				"INSERT INTO `user` (username, password, enabled)" + "VALUES (:username, :password, :enabled)");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("enabled", enabled);
		query.executeUpdate();
		Query query2 = currentSession
				.createSQLQuery("INSERT INTO authorities (username, authority)" + "VALUES (:username, :authority)");
		query2.setParameter("username", username);
		String role = "ROLE_USER";
		query2.setParameter("authority", role);
		query2.executeUpdate();
		currentSession.save(student);
		succ = "User submited successfully";
		return succ;
	}

	@Override
	@Transactional
	public String editStudents(String id, String columnName, String newValue) {
		String succ = "";
		int stud_id = Integer.parseInt(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query query;
		String cName = columnName.toUpperCase();
		if (cName.equals("ID")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession.createQuery("update Student set student_id = :new_id where student_id = :id");
				query.setParameter("new_id", nValue);
				query.setParameter("id", stud_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else if (cName.equals("FIRST NAME")) {
			query = currentSession.createQuery("update Student set first_name = :newFName where student_id = :id");
			query.setParameter("newFName", newValue);
			query.setParameter("id", stud_id);
			query.executeUpdate();
		} else if (cName.equals("LAST NAME")) {
			query = currentSession.createQuery("update Student set last_name = :newLname where student_id = :id");
			query.setParameter("newLname", newValue);
			query.setParameter("id", stud_id);
			query.executeUpdate();
		} else if (cName.equals("USERNAME")) {
			query = currentSession.createQuery("update Student set username = :newUsername where student_id = :id");
			query.setParameter("newUsername", newValue);
			query.setParameter("id", stud_id);
			query.executeUpdate();
		} else if (cName.equals("EMAIL")) {
			query = currentSession.createQuery("update Student set email = :newEmail where student_id = :id");
			query.setParameter("newEmail", newValue);
			query.setParameter("id", stud_id);
			query.executeUpdate();
		} else if (cName.equals("CURRENT SEMESTER")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession
						.createQuery("update Student set current_semester = :newCurrSem where student_id = :id");
				query.setParameter("newCurrSem", nValue);
				query.setParameter("id", stud_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else if (cName.equals("NOT PASSED COURSES")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession
						.createQuery("update Student set num_not_passed_courses = :newNPS where student_id = :id");
				query.setParameter("newNPS", nValue);
				query.setParameter("id", stud_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else if (cName.equals("NUMBER OF APPLICATIONS")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession.createQuery("update Student set num_of_apps = :newNOF where student_id = :id");
				query.setParameter("newNOF", nValue);
				query.setParameter("id", stud_id);
				query.executeUpdate();
			} catch (NumberFormatException e) {
				return "failed";
			}
		} else if (cName.equals("ENABLED")) {
			try {
				int nValue = Integer.parseInt(newValue);
				query = currentSession.createQuery("update Student set enabled = :newEnabled where student_id = :id");
				query.setParameter("newEnabled", nValue);
				query.setParameter("id", stud_id);
				query.executeUpdate();
				String username = getStudentUsername(id);
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
	public String getStudentUsername(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createSQLQuery("select username from student where student_id = '" + id + "'");
		String username = (String) query.uniqueResult();
		return username;
	}

	@Override
	@Transactional
	public String changePassword(String id, String password) {
		String succ = "";
		String username = getStudentUsername(id);
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createSQLQuery(
				"update `user` set `password` = '" + password + "' where  username = '" + username + "'");
		query.executeUpdate();
		return succ = "Password changed Successfully";
	}

}
