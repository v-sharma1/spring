package guru.springframework.didemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.didemo.examplebeans.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {
	
	@Autowired
	Environment env;

	@Value("${db.user}")
	String user;
	
	@Value("${db.password}")
	String password;
	
	@Value("${db.url}")
	String url;
	
	// Binding the values from property file into the datasource bean
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		// Commenting the next line so that we read the property from the env
		// instead of the property file
//		fakeDataSource.setUser(user);
		// We have added an environment property "db_user" as underscore is
		// the normal convention but a dot will also work
		fakeDataSource.setUser(env.getProperty("db.user"));
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		
		return fakeDataSource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
				new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
