package ru.lernup.springjpalern.dao;

import ru.lernup.springjpalern.dao.entity.Book;
import ru.lernup.springjpalern.dao.entity.BookStore;
import ru.lernup.springjpalern.dao.entity.Employee;
import ru.lernup.springjpalern.dao.entity.OrderConsumer;

import java.util.List;

public interface BookStoreDao {
    List<Book> getAllBook();
    List<OrderConsumer> getAllOrderByIDStore(Long id);
    List<Employee> getAllEmployeeByIDStore(Long id);
    List<BookStore> getAllBookStore();
    BookStore getStoreById(Long id);
    BookStore getStoreByName(String name);
}
