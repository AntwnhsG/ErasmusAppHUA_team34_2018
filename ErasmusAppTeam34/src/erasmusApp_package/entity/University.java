package erasmusApp_package.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.sql.Insert;

@Entity
@Table(name = "university")
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "university_id")
	private int university_id;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "univ_name")
	private String univ_name;

	@Column(name = "available_room")
	private int available_room;

	public int getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(int university_id) {
		this.university_id = university_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUniv_name() {
		return univ_name;
	}

	public void setUniv_name(String univ_name) {
		this.univ_name = univ_name;
	}

	public int getAvailable_room() {
		return available_room;
	}

	public void setAvailable_room(int available_room) {
		this.available_room = available_room;
	}
	@Override
	public String toString() {
		return "Student [id=" + university_id + ", country=" + country + ", city=" + city + ", univ_name=" + univ_name + "available_room=" + available_room+ "]";
	}
	
}
