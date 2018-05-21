package guru.springframework.joke.jokeapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.joke.jokeapp.services.JokeService;

@Controller
public class JokeController {
	
	private JokeService jokeService;

	@Autowired
	public JokeController(JokeService jokeService) {
		this.jokeService = jokeService;
	}
	
	// All requests map to this method
	@RequestMapping({"/", ""})
	public String showJoke(Model model) {
		
		model.addAttribute("joke", jokeService.getJoke());
		
		// Return view name used by Thymelef template
		return "chucknorris";
	}

}
