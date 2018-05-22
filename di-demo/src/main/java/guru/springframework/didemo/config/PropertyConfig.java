package guru.springframework.didemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.didemo.examplebeans.FakeDataSource;
import guru.springframework.didemo.examplebeans.FakeJMSBroker;

@Configuration
//@PropertySource("classpath:datasource.properties")
// Use the following for syntax multiple property files
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
// Commented the PropertySource annotation and using the following PropertySources
// annotation. Its just another more readable way of specifying multiple property
// files. Its better illustrated when you have lot of property files
@PropertySources({
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:jms.properties")
})
public class PropertyConfig {
	
	@Autowired
	Environment env;

	@Value("${db.user}")
	String user;
	
	@Value("${db.password}")
	String password;
	
	@Value("${db.url}")
	String url;
	
	@Value("${jms.user}")
	String jms_user;
	
	@Value("${jms.password}")
	String jms_password;
	
	@Value("${jms.url}")
	String jms_url;
	
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
	public FakeJMSBroker fakeJMSBroker() {
		FakeJMSBroker fakeJMSBroker = new FakeJMSBroker();
		fakeJMSBroker.setUser(jms_user);
		fakeJMSBroker.setPassword(jms_password);
		fakeJMSBroker.setUrl(jms_url);
		
		return fakeJMSBroker;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
