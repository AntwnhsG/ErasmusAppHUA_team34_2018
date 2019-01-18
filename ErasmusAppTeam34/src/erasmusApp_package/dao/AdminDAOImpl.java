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
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Student> getStudents() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Student> query = currentSession.createQuery("from Student", Student.class);

		List<Student> students = query.getResultList();

		return students;
	}

	@Override
	@Transactional
	public List<Secretary> getSecEmployees() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Secretary> query = currentSession.createQuery("from Secretary", Secretary.class);

		List<Secretary> secEmployees = query.getResultList();

		return secEmployees;

	}
}
