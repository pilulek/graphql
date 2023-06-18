CREATE TABLE book (
    book_id SERIAL PRIMARY KEY NOT NULL,
    title varchar(512)
    );

CREATE TABLE author (
    author_id SERIAL PRIMARY KEY NOT NULL,
    name varchar(256)
    );

CREATE TABLE books_and_authors (
    id        BIGSERIAL PRIMARY KEY,
    book_id INTEGER NOT NULL REFERENCES book,
    author_id INTEGER NOT NULL REFERENCES author,
    UNIQUE (book_id, author_id)
    );