package erasmusApp_package.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int student_id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	@Column(name = "current_semester")
	private String current_semester;
	
	@Column(name = "num_not_passed_courses")
	private String num_not_passed_courses;
	
	@Column(name = "num_of_apps")
	private int numOfApps;
	
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getCurrent_semester() {
		return current_semester;
	}

	public void setCurrent_semester(String current_semester) {
		this.current_semester = current_semester;
	}

	public String getNum_not_passed_courses() {
		return num_not_passed_courses;
	}

	public void setNum_not_passed_courses(String num_not_passed_courses) {
		this.num_not_passed_courses = num_not_passed_courses;
	}
	
	public int getNumOfApps() {
		return numOfApps;
	}

	public void setNumOfApps(int numOfApps) {
		this.numOfApps = numOfApps;
	}



	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "stud_id")
	private List<Application> applications;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setApps(List<Application> applications) {
		this.applications = applications;	
	}
	
	public List<Application> getApps() {
		return applications;
	}

	@Override
	public String toString() {
		return "Student [id=" + student_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
