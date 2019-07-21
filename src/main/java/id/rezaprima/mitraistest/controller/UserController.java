package id.rezaprima.mitraistest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
		result = validate(user, result);
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

	private BindingResult validate(@Valid User user, BindingResult result) {
		if(userRepository.findByEmail(user.getEmail())!= null) {
			result.addError(new FieldError("user", "email", "email is already taken"));
		}
		if(userRepository.findByMobile(user.getMobileNumber())!= null) {
			result.addError(new FieldError("user", "mobileNumber", "mobile number is already taken"));
		}
		return result;

	}
}
