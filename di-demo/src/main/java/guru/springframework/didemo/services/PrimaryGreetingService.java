package guru.springframework.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Use Primary annotation to mark this class as default implementation
// of GreetingService interface so that while autowiring if no 
// qualifier is specified, this class will be injected

// Use the default keyword in Profile annotation so that this bean is
// selected when no profile value is set i.e. the config file either doesnt
// have entry or the value is blank like shown below
// spring.profiles.active=
// Note, providing wrong profile value in config file like 'xyz' will
// not trigger the default profile

@Service
@Primary
@Profile({"en", "default"})
public class PrimaryGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello! Primary greeting service.";
	}

}
