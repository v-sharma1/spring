package guru.springframework.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Use Primary annotation to mark this class as default implementation
// of GreetingService interface so that while autowiring if no 
// qualifier is specified, this class will be injected

@Service
@Primary
@Profile("en")
public class PrimaryGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello! Primary greeting service.";
	}

}
