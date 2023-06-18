package dev.graphql.service;

import dev.graphql.repository.entity.Author;
import dev.graphql.repository.entity.Book;

import java.util.Collection;

public interface AuthorService {
  Author getAuthor(String name);
  Author saveAuthor(String name, Collection<Book> books);
}
