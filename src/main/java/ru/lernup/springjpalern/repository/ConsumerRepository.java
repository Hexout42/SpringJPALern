package ru.lernup.springjpalern.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.springjpalern.dao.entity.Consumer;
@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Integer> {
    Consumer findConsumerByAllNameConsumer(String name);
}