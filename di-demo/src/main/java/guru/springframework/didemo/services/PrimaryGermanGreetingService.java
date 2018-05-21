package guru.springframework.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
// Commented annotations as it has been moved to Java config file

import guru.springframework.didemo.repositories.GreetingRepository;

//@Service
//@Profile("de")
//@Primary
public class PrimaryGermanGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;

	public PrimaryGermanGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}
	
	@Override
	public String sayGreeting() {
		return greetingRepository.getGermanGreeting();
	}

}
