package dev.graphql.controller;

import dev.graphql.repository.entity.Author;
import dev.graphql.repository.entity.Book;
import dev.graphql.service.AuthorService;
import dev.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Collection;

@org.springframework.stereotype.Controller
public class Controller {
  private final BookService bookService;
  private final AuthorService authorService;

  @Autowired
  public Controller(BookService bookService, AuthorService authorService) {
    this.bookService = bookService;
    this.authorService = authorService;
  }

    @QueryMapping
  public Collection<Book> getBooksByAuthor(@Argument Author author) {
    return bookService.getBooksByAuthor(author);
  }

  @QueryMapping
  public Collection<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @QueryMapping
  public Author getAuthor(@Argument String name) {
    return authorService.getAuthor(name);
  }

  @MutationMapping
  public void saveBook(@Argument String title, @Argument Collection<Author> authors) {
    bookService.saveBook(title, authors);
  }

  @MutationMapping
  public void saveAuthor(@Argument String name, @Argument Collection<Book> books) {
    authorService.saveAuthor(name, books);
  }
}
