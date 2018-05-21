package guru.springframework.joke.jokeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Access the Joke's application on http://localhost:8080/

// Also a custom banner is setup in banner.txt where the text
// generated from "ASCII Art" website http://patorjk.com
// The content of banner.txt is by default picked up by framework
// to display at runtime

@SpringBootApplication
public class JokeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokeappApplication.class, args);
	}
}
