package dev.graphql.repository;

import dev.graphql.repository.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
      Author findByName(String name);
}
