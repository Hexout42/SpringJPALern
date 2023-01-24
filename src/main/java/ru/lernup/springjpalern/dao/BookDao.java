package ru.lernup.springjpalern.dao;

import ru.lernup.springjpalern.dao.entity.Book;

import java.util.List;

public interface BookDao {
    Book getById(long id);
    List<Book> getAll();
    void save(Book book);
    void deleteByID(long id);
    Integer getQuantity(long id);
    Book findBookByNameBook(String name);

}
