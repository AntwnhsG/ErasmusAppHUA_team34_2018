package erasmusApp_package.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import erasmusApp_package.dao.StudentDAO;
import erasmusApp_package.dao.ApplicationDAO;
import erasmusApp_package.entity.Application;
import erasmusApp_package.entity.Student;
import erasmusApp_package.entity.University;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentDAO StudentDAO;
	
	@Autowired
	private ApplicationDAO ApplicationDAO;
	//send to home page
	@RequestMapping("/home")
	public String home() {
		return "student_home";
	}
	
	//send to jsp page for user to fill parameters for his application
	@RequestMapping("/createAppForm")
	public String createAppForm(HttpServletRequest request, Model model) {
		int sID = Integer.parseInt(request.getParameter("stud_id"));
		model.addAttribute("sID", sID);
		return "student_createApplicationForm";
	}
	//create the application
	@RequestMapping("/createApplication")
	public String createApplication(HttpServletRequest request, Model model1, Model model2) {
		String studFirstName = request.getParameter("studFirstName");
		String studLastName = request.getParameter("studLastName");
		String studEmail = request.getParameter("studEmail");
		int sID = Integer.parseInt(request.getParameter("stud_id"));
		String languageOption = request.getParameter("language_button");
		int univ_id = Integer.parseInt(request.getParameter("univ_id"));
		String succ = ApplicationDAO.submitApplication(studFirstName, studLastName, studEmail, sID, univ_id, languageOption);
		model2.addAttribute("stud_id", sID);
		model1.addAttribute("appCreatedMessage", succ);
		return "student_home";
	}

	@RequestMapping("/myApplications")
	public String getStudentApps(HttpServletRequest request, Model model) {
		// get applications from students table
		int sID = Integer.parseInt(request.getParameter("stud_id"));
		List<Application> applications = ApplicationDAO.showMyApplications(sID);
		model.addAttribute("applications", applications);
		return "stud_showApplications";
	}
	
	@RequestMapping("/getStudent")
	public String getStudentId(HttpServletRequest request, Model model) {
			int id = StudentDAO.getSID(request.getParameter("username"));
			model.addAttribute("stud_id", id);
		return "student_home";
	}

}
