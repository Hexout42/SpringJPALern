package ru.lernup.springjpalern.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.springjpalern.dao.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
    Book findBookByNameBook(String name);
}
