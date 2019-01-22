package erasmusApp_package.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import erasmusApp_package.dao.StudentDAO;
import erasmusApp_package.dao.ApplicationDAO;
import erasmusApp_package.dao.UniversityDAO;
import erasmusApp_package.entity.Application;
import erasmusApp_package.entity.Student;
import erasmusApp_package.entity.University;

//@RestController
@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDAO StudentDAO;

	@Autowired
	private ApplicationDAO ApplicationDAO;
	@Autowired
	private UniversityDAO UniversityDAO;

	private int id;

	@RequestMapping("/")
	public String studentWelcomePage(HttpServletRequest request, Model model) {
		return "studentWelcomePage";
	}

	// send to home page
	@RequestMapping("/home")
	public String home() {
		return "student_home";
	}

	// send to jsp page for user to fill parameters for his application
	@RequestMapping("/createAppForm")
	public String createAppForm(HttpServletRequest request, Model model) {
		// id = Integer.parseInt(request.getParameter("stud_id"));
		Student student = StudentDAO.getStudInfo(id);
		if (student.getNumOfApps() >= 3) {
			String message = "You have reached the limit of the applications you can submit";
			List<University> universities = UniversityDAO.getUniversities();
			model.addAttribute("message", message);		
			model.addAttribute("universities", universities);
			return "student_home";

		}
		model.addAttribute("sID", id);
		return "student_createApplicationForm";
	}

	// create the application
	@RequestMapping("/createApplication")
	public String createApplication(HttpServletRequest request, Model model1, Model model2) {
		String studFirstName = request.getParameter("studFirstName");
		String studLastName = request.getParameter("studLastName");
		String studEmail = request.getParameter("studEmail");
		// id = Integer.parseInt(request.getParameter("stud_id"));
		String languageOption = request.getParameter("language_button");
		int univ_id = Integer.parseInt(request.getParameter("univ_id"));
		List<Integer> univ_ids = ApplicationDAO.getUniv_ids(id);
		String message = ApplicationDAO.checkUnivDuplication(univ_id, univ_ids);
		if (message.equals("failed")) {
			String succ = "You have already submitted an application for this University";
		} else {
			String succ = ApplicationDAO.submitApplication(studFirstName, studLastName, studEmail, id, univ_id,
					languageOption);
			StudentDAO.setNumOfApps(id);
			model2.addAttribute("stud_id", id);
			model1.addAttribute("appCreatedMessage", succ);
		}
		return "student_home";
	}

	//@RequestMapping("/myApplications")
	@GetMapping("/myApplications")
	public String getStudentApps(HttpServletRequest request, Model model) {
		// get applications from students table
		// id = Integer.parseInt(request.getParameter("stud_id"));
		List<Application> applications = ApplicationDAO.showMyApplications(id);
		model.addAttribute("applications", applications);
		return "student_showApplications";
	}

	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public String getStudentId(HttpServletRequest request, Model model) {
		Principal principal = request.getUserPrincipal();
		id = StudentDAO.getSID(principal.getName());
		model.addAttribute("stud_id", id);
		return "student_home";
	}

	@RequestMapping("Log_Out")
	public String logOut(HttpServletRequest request) throws ServletException {
		request.logout();
		return "/login_form";
	}

	@RequestMapping("student_Profile")
	public String showUserProfile(HttpServletRequest request, Model model) {
		// id = Integer.parseInt(request.getParameter("id"));
		Student student = StudentDAO.getStudInfo(id);
		model.addAttribute("student", student);
		return "student_ProfileForm";
	}

}
