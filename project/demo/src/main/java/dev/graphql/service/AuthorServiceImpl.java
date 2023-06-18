package dev.graphql.service;

import dev.graphql.repository.AuthorRepository;
import dev.graphql.repository.entity.Author;
import dev.graphql.repository.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;

  @Autowired
  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }
  @Override
  public Author getAuthor(String name) {
    return authorRepository.findByName(name);
  }

  @Override
  public Author saveAuthor(String name, Collection<Book> books) {
    Author author = findOrCreate(name);
    author.setBooks(books);
    return authorRepository.save(author);
  }

  private Author findOrCreate(String name) {
    Author existed = authorRepository.findByName(name);
    if (existed != null) {
      return existed;
    }
    return createAuthor(name);
  }

  private Author createAuthor(String name) {
    Author author = new Author();
    author.setName(name);
    return authorRepository.save(author);
  }
}
