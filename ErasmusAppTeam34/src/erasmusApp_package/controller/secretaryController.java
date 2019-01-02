package erasmusApp_package.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import erasmusApp_package.entity.University;
import erasmusApp_package.dao.UniversityDAO;

@Controller
@RequestMapping("/sec")
public class secretaryController {
	
	@Autowired
	private UniversityDAO UniversityDAO;
	
	@RequestMapping("/")
	public String showOptions() {
		return "sec_univOptions";
	}
	//get all universities from the database
	@RequestMapping("/univList")
	public String getUniversities(Model model){
		// get universities from university table
		List<University> universities = UniversityDAO.getUniversities();

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
		model.addAttribute("Uni_infoAddedMessage", succ);
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
		return "editAppPage";
	}
	// update the univetsity selected from the jsp page (update database)
	@RequestMapping("/updateUniv")
	public String updateUniv(HttpServletRequest request, Model model) {
		String columnName = request.getParameter("columnName");
		String newValue = request.getParameter("newValue");
		String id = request.getParameter("id");
		String succ = UniversityDAO.updateUniversity(columnName, newValue, id);
		model.addAttribute("UpdateStatus", succ);
		return "sec_univOptions";
	}
	//NOT READY
	//delete the selected university (from database)
	@RequestMapping("/deleteUni")
	public String deleteUni(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String succ = UniversityDAO.deleteUniversity(id);
		model.addAttribute("deleteStatus", succ);
		return "sec_univOptions";
	}
}
