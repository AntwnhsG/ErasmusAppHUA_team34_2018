package erasmusApp_package.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import erasmusApp_package.dao.AdminDAO;
import erasmusApp_package.dao.SecretaryDAO;
import erasmusApp_package.dao.StudentDAO;
import erasmusApp_package.entity.Secretary;
import erasmusApp_package.entity.Student;

@Controller
@RequestMapping("/admin")
public class adminController {
	
	@Autowired
	private AdminDAO AdminDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private SecretaryDAO secretaryDAO;
	
	@RequestMapping("/")
	public String adminOptions() {		
		return "adminPage";
	}
	
	@RequestMapping("/home")
	public String Home() {
		return "adminPage";
	}
	
	@RequestMapping("/showAllUsers")
	public String showUsers(HttpServletRequest request, Model model) {
		List<Student> students = AdminDAO.getStudents();
		List<Secretary> secretaryEmps = AdminDAO.getSecEmployees();
		model.addAttribute("students",students);
		model.addAttribute("secretaryEmps", secretaryEmps);
		return "admin_listAllUsers";
	}
	
	@RequestMapping("/showAddStudentForm")
	public String showAddStudentForm() {		
		return "admin_addStudentForm";
	}
	
	@RequestMapping("/addStudent")
	public String adminAddStudent(HttpServletRequest request, Model model) {	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(request.getParameter("password"));
		String message=studentDAO.addStudents(Integer.parseInt(request.getParameter("id")), request.getParameter("username"), 
				hashedPassword, Integer.parseInt(request.getParameter("enabled")),
				request.getParameter("first_name"),request.getParameter("last_name"), request.getParameter("email"), 
				Integer.parseInt(request.getParameter("currentSemester")), Integer.parseInt(request.getParameter("NPC")));
		model.addAttribute("message", message);
		return "adminPage";
	}
	
	@RequestMapping("/showEditStudentForm")
	public String showEditStudentForm(HttpServletRequest request) {
		request.setAttribute("student_id", request.getParameter("id"));
		return "admin_editStudent";
	}
	@RequestMapping("/editStudent")
	public String adminEditStudent(HttpServletRequest request, Model model) {	
		String message =studentDAO.editStudents(request.getParameter("id"), request.getParameter("columnName"), request.getParameter("newValue"));
		if(message.equals("failed")) {
			model.addAttribute("UpdateStatus", "Wrong column name. please try again");
			return "admin_editStudent";
		}
		model.addAttribute("message", message);
		return "adminPage";
	}
	
	@RequestMapping("/deleteStudent")
	public String adminDeleteStudent(HttpServletRequest request, Model model) {	
		String message =studentDAO.deleteStudents(request.getParameter("id"));
		model.addAttribute("message", message);
		return "adminPage";
	}
	
	
	@RequestMapping("/showAddSecEmpForm")
	public String showAddSecEmpForm() {		
		return "admin_addSecEmp";
	}
	
	@RequestMapping("/addSecretary")
	public String adminAddSecretary(HttpServletRequest request, Model model) {		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(request.getParameter("password"));
		String message =secretaryDAO.addSecEmp(Integer.parseInt(request.getParameter("id")), request.getParameter("first_name"), request.getParameter("last_name"), 
				request.getParameter("username"), hashedPassword,
				Integer.parseInt(request.getParameter("enabled")), request.getParameter("email"));
		model.addAttribute("message", message);
		return "adminPage";
	}
	
	@RequestMapping("/showSecEditForm")
	public String showSecEditForm(HttpServletRequest request) {
		request.setAttribute("sec_id", request.getParameter("id"));
		request.setAttribute("username", request.getParameter("username"));
		return "admin_editSecEmp";
	}
	
	@RequestMapping("/editSecretary")
	public String adminEditSecretary(HttpServletRequest request, Model model) {	
		String message =secretaryDAO.editSecEmp(request.getParameter("id"), request.getParameter("columnName"), request.getParameter("newValue"));
		if(message.equals("failed")) {
			model.addAttribute("UpdateStatus", "Wrong column name. please try again");
			return "admin_editSecEmp";
		}
		model.addAttribute("message", message);
		return "adminPage";
	}
	
	@RequestMapping("/deleteSecretary")
	public String adminDeleteSecretary(HttpServletRequest request, Model model) {		
		String message =secretaryDAO.deleteSecEmp(request.getParameter("id"));
		model.addAttribute("message", message);
		return "adminPage";
	}
	
	@RequestMapping("/studChangePasswordForm")
	public String studChangePasswordForm(HttpServletRequest request, Model model) {
		model.addAttribute("id", request.getParameter("id"));
		return "admin_studChangePassword";
	}
	
	@RequestMapping("/studChangePassword")
	public String studChangePass(HttpServletRequest request, Model model) {
		String message = studentDAO.changePassword(request.getParameter("id"), BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt()));
		model.addAttribute("message", message);
		return "adminPage";
	}
	@RequestMapping("/secChangePasswordForm")
	public String secChangePasswordForm(HttpServletRequest request, Model model) {
		model.addAttribute("id", request.getParameter("id"));
		return "admin_secChangePassword";
	}
	
	@RequestMapping("/secChangePassword")
	public String secChangePass(HttpServletRequest request, Model model) {
		String message = secretaryDAO.changePassword(request.getParameter("id"), BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt()));
		model.addAttribute("message", message);
		return "adminPage";
	}
	
	@RequestMapping("Log_Out")
	public String logOut(HttpServletRequest request) throws ServletException {
		request.logout();
		return "/login_form";
	}
	

}
