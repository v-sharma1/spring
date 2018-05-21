package guru.springframework.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.didemo.repositories.GreetingRepository;

// Use profile to have two separate implementations of beans which you can
// separate on the basis of environment, language, etc.
// Note, the profile value is configured in application.properties so it
// cannot be changed during runtime. So settings like environment (dev, uat, prod, etc)
// are fixed and can be used to define profiles
// Also note that we can have two separate Primary beans defined for different Profiles

// Commented annotations as it has been moved to Java config file

//@Service
//@Profile("es")
//@Primary
public class PrimarySpanishGreetingService implements GreetingService {
	
	private GreetingRepository greetingRepository;

	public PrimarySpanishGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}
	
	@Override
	public String sayGreeting() {
		return greetingRepository.getSpanishGreeting();
	}

}
