package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.domain.Author;
import com.springframework.spring5webapp.domain.Book;
import com.springframework.spring5webapp.domain.Publisher;
import com.springframework.spring5webapp.repositories.AuthorRepository;
import com.springframework.spring5webapp.repositories.BookRepository;
import com.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Detect this class as a spring managed component
@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson"); //Founder of spring framework
    Book noEJB = new Book("J2EE Development without EJB", "3939459569");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEJB);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of books "+bookRepository.count());

    Publisher puff = new Publisher();
    puff.setAddress("SFG Publishing");
    puff.setCity("St Petersburg");
    puff.setState("FL");
    puff.setZip("96819");

    publisherRepository.save(puff);
    System.out.println(puff);

    ddd.setPublisher(puff);
    puff.getBooks().add(ddd);

    noEJB.setPublisher(puff);
    puff.getBooks().add(noEJB);

    System.out.println("Publisher Number of books: "+ puff.getBooks().size());
  }
}
