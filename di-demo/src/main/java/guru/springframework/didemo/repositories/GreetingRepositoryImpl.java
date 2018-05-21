package guru.springframework.didemo.repositories;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepositoryImpl implements GreetingRepository {

	@Override
	public String getGreeting() {
		return "Hello! Primary greeting service.";
	}

	@Override
	public String getSpanishGreeting() {
		return "¡Hola! Servicio de saludo español primario.";
	}

	@Override
	public String getGermanGreeting() {
		return "Hallo! Primärer Begrüßungsdienst";
	}

}
