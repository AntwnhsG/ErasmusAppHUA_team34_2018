package erasmusApp_package.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@GetMapping("/showLoginForm")
	public String showLoginForm() {
		return "login_form";
	}
}
