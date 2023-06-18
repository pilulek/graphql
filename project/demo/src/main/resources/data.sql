INSERT INTO book (title) VALUES ('Kafka в действии');
INSERT INTO book (title) VALUES ('Необычные книги');
INSERT INTO book (title) VALUES ('Книги необычные');

INSERT INTO author (name) VALUES ('Виктор Гамов');
INSERT INTO author (name) VALUES ('Петр Петров');
INSERT INTO author (name) VALUES ('Виктор Викторов');

INSERT INTO books_and_authors (book_id, author_id) VALUES (1, 1);
INSERT INTO books_and_authors (book_id, author_id) VALUES (3, 2);
INSERT INTO books_and_authors (book_id, author_id) VALUES (2, 3);

select * from book;
select * from author;
select * from books_and_authors;