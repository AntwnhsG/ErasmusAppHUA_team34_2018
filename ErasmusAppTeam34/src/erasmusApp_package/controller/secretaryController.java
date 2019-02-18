package erasmusApp_package.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import erasmusApp_package.entity.Application;
import erasmusApp_package.entity.University;
import erasmusApp_package.dao.UniversityDAO;
import erasmusApp_package.dao.ApplicationDAO;

@Controller
@RequestMapping("/sec")
public class secretaryController {
	
	@Autowired
	private UniversityDAO UniversityDAO;
	
	@Autowired
	private ApplicationDAO ApplicationDAO;
	
	@RequestMapping("/")
	public String showOptions() {
		return "sec_univOptions";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "sec_univOptions";
	}
	
	//get all universities from the database
	@RequestMapping("/univList")
	public String getUniversities(Model model){
		// get universities from university table
		List<University> universities = UniversityDAO.getUniversities();
		if(universities.size() == 0) {
			String message = "There are no universities in the database. Please consider adding one!";
			model.addAttribute("message", message);
			return "sec_univOptions";
		}
		// add the customers to the model
		model.addAttribute("universities", universities);

		return "sec_ShowUniv";
		
	}
	// add a university to the database
	@RequestMapping("/setUniv")
	public String setUniversities(HttpServletRequest request, Model model) {
		//int uni_id = Integer.parseInt(request.getParameter("univ_id"));
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String uni_name = request.getParameter("univ_name");
		int avail_room = Integer.parseInt(request.getParameter("available_room"));
		String succ = UniversityDAO.setUniversity(/*uni_id, */country, city, uni_name, avail_room);
		model.addAttribute("message", succ);
		return "sec_univOptions";
	}
	
	@RequestMapping("/create")
	public String fillCreationForm () {
		return "createUniversity";
	}

	// get the selected university from the jsp page (from database)
	@RequestMapping("/showUniversity")
	public String showUniversity(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		University univ = UniversityDAO.getUniversity(id);
		model.addAttribute("university", univ);
		return "sec_editUnivPage";
	}
	// update the univetsity selected from the jsp page (update database)
	@RequestMapping("/updateUniv")
	public String updateUniv(HttpServletRequest request, Model model) {
		String columnName = request.getParameter("columnName");
		String newValue = request.getParameter("newValue");
		String id = request.getParameter("id");
		String succ = UniversityDAO.updateUniversity(columnName, newValue, id);
		if(succ.equals("failed")) {
			model.addAttribute("message", "Wrong column name or type of value. Please try again");
			return "sec_editUnivPage";
		}
		model.addAttribute("message", succ);
		return "sec_univOptions";
	}
	//NOT READY
	//delete the selected university (from database)
	@RequestMapping("/deleteUni")
	public String deleteUni(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String succ = UniversityDAO.deleteUniversity(id);
		model.addAttribute("message", succ);
		return "sec_univOptions";
	}
	
	@RequestMapping("Log_Out")
	public String logOut(HttpServletRequest request) throws ServletException {
		request.logout();
		return "/login_form";
	}
	
	@RequestMapping("getStudentId")
	public String getStudentId() {	
		return "sec_getStudentId";
	}
	
	@RequestMapping("listApplications")
	public String listAllApplications(HttpServletRequest request, Model model) {	
		List<Application> apps = ApplicationDAO.showMyApplications(Integer.parseInt(request.getParameter("id")));
		if(apps.isEmpty()) {
			String message = "User has no applocations yet";
			model.addAttribute("message", message);
			return "sec_univOptions";
		}
		model.addAttribute("apps", apps);
		return "sec_listAllApplications";
	}
	
	@RequestMapping("deleteApp")
	public String deleteApp(HttpServletRequest request, Model model) {
		String message =ApplicationDAO.deleteApp(request.getParameter("id"), request.getParameter("student_id"));
		model.addAttribute("message", message);
		return "sec_univOptions";
	}
	@RequestMapping("showEditPage")
	public String showEditPage(HttpServletRequest request, Model model) {
		model.addAttribute("id", request.getParameter("id"));
		return "sec_editAppPage";
	}
	
	@RequestMapping("editApplication")
	public String editApplication(HttpServletRequest request, Model model) {
		String message = ApplicationDAO.editApplication(request.getParameter("id"), request.getParameter("columnName"), request.getParameter("nValue"));
		if(message.equals("failed")) {
			model.addAttribute("message", "Wrong column name or type of value. Please try again");
			return "sec_editUnivPage";
		}
		model.addAttribute("message", message);
		return "sec_univOptions";
	}
	
}
