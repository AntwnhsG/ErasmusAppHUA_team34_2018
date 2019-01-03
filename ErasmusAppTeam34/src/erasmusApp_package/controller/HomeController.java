package erasmusApp_package.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import erasmusApp_package.dao.StudentDAO;
import erasmusApp_package.dao.SecretaryDAO;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/")
	public String huaErasmusPage() {
		return "huaErasmus";
	}
/*
	@GetMapping("/showLoginForm")
	public String showLoginForm() {
		return "login_form";
	}
*/
	@Autowired
	private StudentDAO StudentDAO;
	@Autowired
	private SecretaryDAO SecretaryDAO;
//	process login credentials
	@RequestMapping("/processLoginForm")
	public String processLoginForm(HttpServletRequest request, Model model) {

		//int successResult = 0;
		String theUsername = request.getParameter("U_username");
		theUsername = theUsername.toUpperCase();
		String thePassword = request.getParameter("U_password");
		// get customers from dao
		//every secretary user has a username that starts with S
		if (theUsername.startsWith("S")) { 
			//successResult = SecretaryDAO.checkCredentials(theUsername, thePassword);
			//if (successResult == 1) {
				return "sec_home";
			//}
			//every student has a username that starts with E
		} else if (theUsername.startsWith("E")) {
			//successResult = StudentDAO.checkCredentials(theUsername, thePassword);
			//if (successResult == 1) {
				return "studentWelcomePage";
			//}
		}
		return "login_form";
	}
/*
 * 	NOT READY
	@RequestMapping("/news")
	public String news() {
		return "newsPage";
	}
*/
	/*
	 * NEEDS TO BE TRANSFERD TO STUDENT CONTROLLER
	@RequestMapping("/userProfile")
	public String userProfile() {
		return "userProfileForm";
	}

	@RequestMapping("/userApplications")
	public String userApplications() {
		return "userApplicationsForm";
	}

	@RequestMapping("/log_out")
	public String log_out() {
		return "login_form";
	}
*/
}
