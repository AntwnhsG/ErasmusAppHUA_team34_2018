package erasmusApp_package.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stud_application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_Id")
	private int app_Id;
	
	@Column(name = "stud_first_name")
	private String stud_firstName;
	
	@Column(name ="stud_last_name")
	private String stud_lastName;
	
	@Column(name ="stud_email")
	private String stud_email;
	
	@Column(name = "stud_id")
	private int stud_id;
	
	@Column(name = "isApproved")
	private String isApproved;
	
	@Column(name = "knows_the_language")
	private String languageOption;
	
	@Column(name = "univ_id")
	private int univ_id;

	public String getStud_firstName() {
		return stud_firstName;
	}

	public void setStud_firstName(String stud_firstName) {
		this.stud_firstName = stud_firstName;
	}

	public String getStud_lastName() {
		return stud_lastName;
	}

	public void setStud_lastName(String stud_lastName) {
		this.stud_lastName = stud_lastName;
	}

	public String getStud_email() {
		return stud_email;
	}

	public void setStud_email(String stud_email) {
		this.stud_email = stud_email;
	}

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getLanguageOption() {
		return languageOption;
	}

	public void setLanguageOption(String languageOption) {
		this.languageOption = languageOption;
	}

	public int getUniv_id() {
		return univ_id;
	}

	public void setUniv_id(int univ_id) {
		this.univ_id = univ_id;
	}
	
	
}
