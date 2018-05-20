package guru.springframework.didemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.didemo.services.GreetingService;

@Controller
public class ConstructorInjectedController {
	
	private GreetingService greetingService;

	// Autowired annotation is optional for constructor 
	// based injection from Spring 3.2 release
	//
	// The Qualifier annotation is used as there were multiple implementations
	// of GreetingService. Note the name in qualifier starts with small case.
	// 
	// We can also use name of the implementation class (starting with small case)
	// as property and Spring will inject the dependency using Reflection without
	// using the Qualifier but it is not recommended option as it is more error prone
	@Autowired
	public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}

}
