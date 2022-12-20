package telran.java45.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;


import telran.java45.model.Book;

public interface BookRepository {
	
	Stream<Book> findBooksByAuthorsName(String authorName);
	
	Stream<Book> findBooksByPublisherPublisherName(String publisherName);

	boolean existsById(String isbn);
	
	Optional<Book> findById(String isbn);
	
	void delete(String isbn);
	
	void delete(Book book);
	
	void deleteAll(Collection<Book> books);
	
	Book  save(Book book);
}
