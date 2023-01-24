package ru.lernup.springjpalern.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.springjpalern.dao.entity.Author;
import ru.lernup.springjpalern.dao.entity.Book;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    Author findAuthorByAllNameAuthor(String name);


}
