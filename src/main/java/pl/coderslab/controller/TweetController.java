package pl.coderslab.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;
    
   
	@ModelAttribute("users")
	public List<User> users() {
		return userRepository.findAll();
	}
    
    @GetMapping("/add")
    public String tweetAdd(Model model) {
        model.addAttribute("tweet", new Tweet());
        return "tweetForm";
    }

    @PostMapping("/add")
    public String tweetSave(@Valid @ModelAttribute Tweet tweet, BindingResult result){
        tweet.setCreated(LocalDate.now());
        if(result.hasErrors()){
            return "tweetForm";
        }
        tweetRepository.save(tweet);
        return "redirect:/user/all";
    }

}