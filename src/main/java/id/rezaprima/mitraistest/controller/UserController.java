package id.rezaprima.mitraistest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import id.rezaprima.mitraistest.model.User;
import id.rezaprima.mitraistest.repo.UserRepository;

@Controller
public class UserController {
	private final UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/register")
	public String showRegisterForm(User user) {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		
		userRepository.save(user);
		return "login";
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
}
