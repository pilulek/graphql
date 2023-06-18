package dev.graphql.service;

import dev.graphql.repository.entity.Author;
import dev.graphql.repository.entity.Book;

import java.util.Collection;
import java.util.List;

public interface BookService {
  Collection<Book> getBooksByAuthor(Author author);
  List<Book> getAllBooks();
  Book saveBook(String title, Collection<Author> authors);
}
