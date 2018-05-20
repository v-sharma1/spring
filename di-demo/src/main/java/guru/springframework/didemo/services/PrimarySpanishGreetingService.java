package guru.springframework.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Use profile to have two separate implementations of beans which you can
// separate on the basis of environment, language, etc.
// Note, the profile value is configured in application.properties so it
// cannot be changed during runtime. So settings like environment (dev, uat, prod, etc)
// are fixed and can be used to define profiles
// Also note that we can have two separate Primary beans defined for different Profiles
@Service
@Profile("es")
@Primary
public class PrimarySpanishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "¡Hola! Servicio de saludo español primario.";
	}

}
