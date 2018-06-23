package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;


@Controller
public class HomeController {

	@Autowired
	TweetRepository tweetRepository;

	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/user/{id}/tweets")
	public String userTweets(@PathVariable long id, Model model) {
		List<Tweet> tweets = tweetRepository.findAllByUserId(id);
		model.addAttribute("tweets", tweets);
		return "tweetList";
	}

	@GetMapping("user/search-tweets/{start}")
	public String userTweetName( @PathVariable String start, Model model) {
		List<Tweet> tweets = tweetRepository.findAllByTitleLike(start);
		model.addAttribute("tweets", tweets);
		return "tweetList";
	}
	 
        
}