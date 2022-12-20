package telran.java45.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import telran.java45.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Stream<Book> findBooksByAuthorsName(String authorName) {
		TypedQuery<Book> query = em.createQuery("select distinct b from Book b join b.authors a where a.name=?1", Book.class);
		query.setParameter(1, authorName);
		return query.getResultList().stream();
	}

	@Override
	public Stream<Book> findBooksByPublisherPublisherName(String publisherName) {
		TypedQuery<Book> query = em.createQuery("select b from Book b where  b.publisher.publisherName = ?1", Book.class);
		query.setParameter(1, publisherName);
		return query.getResultList().stream();
	}

	@Override
	public boolean existsById(String isbn) {
		return em.find(Book.class, isbn) != null;
	}

	@Override
	public Optional<Book> findById(String isbn) {
		return Optional.ofNullable(em.find(Book.class, isbn));
	}

	@Override
	public void delete(String isbn) {
		Book book = em.find(Book.class, isbn);
		em.remove(book);
	}

	@Override
	public void delete(Book book) {
		em.remove(book);
	}
	
	@Override
	public void deleteAll(Collection<Book> books) {
		books.stream().forEach(b->delete(b));
	}

	@Override
	@Transactional
	public Book save(Book book) {
		em.persist(book);
		return book;
	}



}
