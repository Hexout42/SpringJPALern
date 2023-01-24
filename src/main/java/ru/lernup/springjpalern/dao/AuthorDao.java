package ru.lernup.springjpalern.dao;

import ru.lernup.springjpalern.dao.entity.Author;
import ru.lernup.springjpalern.dao.entity.Book;

import java.util.List;

public interface AuthorDao {
    Author getById(Long id);
    List<Author> getAll();
    void save(Author author);
    void deleteById(Long  id);
    List<Book> getBooks(Long id);

}
