package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;

/**
 * 
 * Access the H2 database from the URL http://localhost:8080/h2-console
 * 
 * Make sure to use the in-memory JDBC URL: jdbc:h2:mem:testdb
 * 
 * Other details are:
 * Driver class: org.h2.Driver
 * User name: sa
 * Password: <blank>
 * 
 */
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}



	private void initData() {
		// Eric
		Author eric = new Author("Eric", "Evans");
		Publisher harp = new Publisher("Harper Collins", "address 1");
		Book ddd = new Book("Domain Driven Design", "1234", harp);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		publisherRepository.save(harp);
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Publisher wrox = new Publisher("Wrox", "address 2");
		Book noEJB = new Book("J2EE Development Without EJB", "23444", wrox);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		publisherRepository.save(wrox);
		authorRepository.save(rod);
		bookRepository.save(noEJB);

	}
	
	

}
