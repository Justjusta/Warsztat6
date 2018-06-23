package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TweetRepository tweetRepository;

	@ModelAttribute("tweets")
	public List<Tweet> tweetss() {
		return tweetRepository.findAll();
	}

	@GetMapping("/add")
	public String userAdd(Model model) {
		model.addAttribute("user", new User());
		return "userForm";
	}

	@PostMapping("/add")
	public String userSave(@Valid @ModelAttribute User user, BindingResult result) {
		if (result.hasErrors()) {
			return "userForm";
		}
		userRepository.save(user);
		return "redirect:/user/all";
	}

	@GetMapping("/all")
	public String allBooks(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "userList";
	}

	@GetMapping("/{id}/edit")
	public String editUserForm(@PathVariable long id, Model model) {
		model.addAttribute("user", userRepository.findOne(id));
		return "userForm";
	}

	@PostMapping("/{id}/edit")
	public String editUserForm(@PathVariable long id, @ModelAttribute User user, Model model) {
		userRepository.save(user);
		return "redirect:/user/all";
	}

	@GetMapping("/{id}/delete")
	public String deleteUserForm(@PathVariable long id) {
		userRepository.delete(id);
		return "redirect:/user/all";
	}

}
