package guru.springframework.joke.jokeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

// Access the Joke's application on http://localhost:8080/

// Also a custom banner is setup in banner.txt where the text
// generated from "ASCII Art" website http://patorjk.com
// The content of banner.txt is by default picked up by framework
// to display at runtime
// This project also covers different types of possible configurations
//
// The ImportResource is importing the XML based config file
// Note: Same class has also been configured using Java based config

@SpringBootApplication
@ImportResource("classpath:chuck-config.xml")
public class JokeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokeappApplication.class, args);
	}
}
