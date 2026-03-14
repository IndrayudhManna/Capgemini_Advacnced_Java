package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@GetMapping("/")

	public String loginPage() {
		return "login.jsp";
	}

	@PostMapping("/login")
	public String validate(String user, String password) {
		System.out.println(user);
		System.out.println(password);

		return "home.jsp";
	}

	@GetMapping("/signup")

	public String signUp() {
		return "register.jsp";

	}

	@GetMapping("/forgetpassword")

	public String forget() {
		return "forget.jsp";
	}

}