package dev.graphql.service;

import dev.graphql.repository.AuthorRepository;
import dev.graphql.repository.BookRepository;
import dev.graphql.repository.entity.Author;
import dev.graphql.repository.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  @Autowired
  public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  @Override
  public Collection<Book> getBooksByAuthor(Author author) {
    if (author.getId() != null) {
      return getBooksByAuthor(author.getId());
    }
    return getBooksByAuthor(author.getName());
  }
  private Collection<Book> getBooksByAuthor(int authorId) {
    Optional<Author> author = authorRepository.findById(authorId);
    if (author.isPresent()) {
      return author.get().getBooks();
    }
    return Collections.emptyList();
  }

  private Collection<Book> getBooksByAuthor(String name) {
    return authorRepository.findByName(name).getBooks();
  }

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Book saveBook(String title, Collection<Author> authors) {
    Book book = findOrCreate(title);
    book.setAuthors(authors);
    return bookRepository.save(book);
  }

  private Book findOrCreate(String title) {
    Book existed = bookRepository.findByTitle(title);
    if (existed != null) {
      return existed;
    }
    return createBook(title);
  }

  private Book createBook(String title) {
    Book book = new Book();
    book.setTitle(title);
    return bookRepository.save(book);
  }
}
