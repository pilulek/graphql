# Реализован сервис, принимающий и обрабатывающий GraphQL-запросы:

mutations:
saveBook(title, authors), 
saveAuthor(name, books) 

queries:
getBooksByAuthor(author) - получить список книг по автору, 
getAllBooks() - получить все книги, 
getAuthor(name) - вывод автора (в т.ч. со списком книг автора) 

Хранимые сущности:
Book (id, title, authors)
Author (id, name, books)
