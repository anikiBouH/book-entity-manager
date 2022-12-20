package telran.java45.dao;

import java.util.List;
import java.util.Optional;

import telran.java45.model.Publisher;

public interface PublicherRepository{

//  @Query("select distinct p.publisherName from Book b join b.authors a join b.publisher p where a.name=?1")
	List<String> findPublishersByAuthor(String authorName);

	Optional<Publisher> findById(String publisher);

	Publisher save(Publisher publisher);
}
