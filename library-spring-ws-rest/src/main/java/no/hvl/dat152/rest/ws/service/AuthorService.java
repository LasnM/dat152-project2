/**
 * 
 */
package no.hvl.dat152.rest.ws.service;

import java.util.List;
import java.util.Set;

import no.hvl.dat152.rest.ws.exceptions.UserNotFoundException;
import no.hvl.dat152.rest.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat152.rest.ws.exceptions.AuthorNotFoundException;
import no.hvl.dat152.rest.ws.model.Author;
import no.hvl.dat152.rest.ws.model.Book;
import no.hvl.dat152.rest.ws.repository.AuthorRepository;

/**
 * @author tdoy
 */
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Author findById(long id) throws AuthorNotFoundException {
		
		Author author = authorRepository.findById(id)
				.orElseThrow(()-> new AuthorNotFoundException("Author with the id: "+id+ "not found!"));
		
		return author;
	}
	
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public Author updateAuthor(int id, Author author) {
		return authorRepository.save(author);
	}
	
	public List<Author> findAll() {
		return (List<Author>) authorRepository.findAll();
	}
	
	public void deleteById(Long id) throws AuthorNotFoundException {
		Author author = authorRepository.findById(id)
				.orElseThrow(()-> new AuthorNotFoundException("Author with id: " + id + " not found"));
		authorRepository.delete(author);
	}
	
	public Set<Book> findBooksByAuthorId(Long id) throws AuthorNotFoundException {
		Author author = authorRepository.findById(id)
				.orElseThrow(()-> new AuthorNotFoundException("Author with id: " + id + " not found"));
		return author.getBooks();
	}
}
