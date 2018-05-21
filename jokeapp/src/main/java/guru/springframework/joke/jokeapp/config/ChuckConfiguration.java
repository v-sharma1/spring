package guru.springframework.joke.jokeapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

// Java based configuration example
// Particularly useful when you are using a third party class
// which cannot be Spring annotated like the class we have used
// in our example. 
//
// Note: Same class has also been configured using XML based config

@Configuration
public class ChuckConfiguration {
	
	@Bean
	public ChuckNorrisQuotes chuckNorrisQuotes() {
		return new ChuckNorrisQuotes();
	}
}
