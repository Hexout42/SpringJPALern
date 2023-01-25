package ru.lernup.springjpalern.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.springjpalern.dao.entity.BookStore;
@Repository
public interface BookStoreRepository extends CrudRepository<BookStore, Long> {
    BookStore findBookStoreByName(String name);
}