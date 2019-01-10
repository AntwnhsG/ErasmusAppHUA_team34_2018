package erasmusApp_package.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import erasmusApp_package.dao.StudentDAO;
import erasmusApp_package.dao.SecretaryDAO;

@Controller
@RequestMapping("/")
public class HomeController {
/*
	@RequestMapping("/")
	public String huaErasmusPage() {
		return "huaErasmus";
	}
	*/
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
	//@RequestMapping("/processLoginForm")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@ResponseBody
	public String processLoginForm(HttpServletRequest request, Model model) {
		Principal principal = request.getUserPrincipal();
		//int successResult = 0;
		String returnValue = "";
		String theUsername = principal.getName();
		theUsername = theUsername.toUpperCase();
		//String thePassword = request.getParameter("U_password");
		// get customers from dao
		//every secretary user has a username that starts with S
		if (theUsername.startsWith("S")) { 
			//successResult = SecretaryDAO.checkCredentials(theUsername, thePassword);
			//if (successResult == 1) {
				returnValue = "sec_home";
			//}
			//every student has a username that starts with E
		} else if (theUsername.startsWith("E")) {
			//successResult = StudentDAO.checkCredentials(theUsername, thePassword);
			//if (successResult == 1) {
				model.addAttribute("username", theUsername);
				returnValue = "studentWelcomePage";
			//}
		}
		return returnValue;
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
