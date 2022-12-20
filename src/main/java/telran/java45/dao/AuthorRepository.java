package telran.java45.dao;

import java.util.Optional;

import telran.java45.model.Author;



public interface AuthorRepository {
	Optional<Author> findById(String authorName);
	
	Author save(Author author);
	
	void delete(Author author);
}
