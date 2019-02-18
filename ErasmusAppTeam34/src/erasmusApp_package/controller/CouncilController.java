package erasmusApp_package.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import erasmusApp_package.dao.ApplicationDAO;
import erasmusApp_package.dao.UniversityDAO;
import erasmusApp_package.dao.AdminDAO;
import erasmusApp_package.entity.Application;
import erasmusApp_package.entity.Student;

@Controller
@RequestMapping("/council")
public class CouncilController {

	@Autowired
	private ApplicationDAO ApplicationDAO;
	@Autowired
	private AdminDAO AdminDAO;
	
	@Autowired
	private UniversityDAO UniversityDAO;
	
	@RequestMapping("/")
	public String Home() {
		
		return "council_Home";
	}
	
	@RequestMapping("/home")
	public String homePage(){
		return "council_Home";
	}
	
	@RequestMapping("/showStudents")
	public String showStudents(HttpServletRequest request, Model model) {
		List<Student> studs = AdminDAO.getStudents();
		model.addAttribute("studs", studs);
		return "council_students";
	}
	
	@RequestMapping("/getApplications")
	public String getApplications(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Application> apps = ApplicationDAO.showMyApplications(id);
		if(apps.isEmpty()) {
			model.addAttribute("message", "There are no applications submitted yet");
			return "council_Home";
		}
		model.addAttribute("applications", apps);
		return "council_ShowApps";
	}
	
	@RequestMapping("/editApplicationStatus")
	public String editApplicationStatus(HttpServletRequest request, Model model) {
		if(request.getParameter("status").equals("YES")) {
			String succ = UniversityDAO.univRoomUpdate(Integer.parseInt(request.getParameter("univ_id")));
			if(succ.equals("failed")) {
				model.addAttribute("message", "No more room available at this university");
				return "council_Home";
			}
		}
		String message = ApplicationDAO.setAppStatus(request.getParameter("status"), Integer.parseInt(request.getParameter("id")));
		model.addAttribute("mesage", message);
		return "council_Home";
	}
	
	@RequestMapping("/Log_Out")
	public String logOut(HttpServletRequest request) throws ServletException {
		request.logout();
		return "/login_form";
	}
	
}
