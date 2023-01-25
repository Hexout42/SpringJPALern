package ru.lernup.springjpalern.dao.data;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import ru.lernup.springjpalern.dao.BookStoreDao;
import ru.lernup.springjpalern.dao.entity.Book;
import ru.lernup.springjpalern.dao.entity.BookStore;
import ru.lernup.springjpalern.dao.entity.Employee;
import ru.lernup.springjpalern.dao.entity.OrderConsumer;
import ru.lernup.springjpalern.repository.BookStoreRepository;

import java.util.ArrayList;
import java.util.List;
@Component
public class SpringDataBookStore implements BookStoreDao {
    private final BookStoreRepository bookStoreRepository;

    public SpringDataBookStore(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<>();
        bookStoreRepository.findAll().forEach(bookStore -> {
           bookStore.getBookList().forEach(book -> {
               books.add(book);
           });
            });

        return books;
    }

    @Override
    public List<OrderConsumer> getAllOrderByIDStore(Long id) {
        return bookStoreRepository.findById(id).orElseThrow(EntityNotFoundException::new).getOrders();
    }

    @Override
    public List<Employee> getAllEmployeeByIDStore(Long id) {
        return bookStoreRepository.findById(id).orElseThrow(EntityNotFoundException::new).getEmployees();
    }

    @Override
    public List<BookStore> getAllBookStore() {
        List<BookStore> bookStores = new ArrayList<>();
        bookStoreRepository.findAll().forEach(bookStores::add);
        return bookStores;

    }

    @Override
    public BookStore getStoreById(Long id) {
        return bookStoreRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public BookStore getStoreByName(String name) {
        return bookStoreRepository.findBookStoreByName(name);
    }

}
