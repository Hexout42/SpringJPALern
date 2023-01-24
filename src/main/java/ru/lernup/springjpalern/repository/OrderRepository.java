package ru.lernup.springjpalern.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.springjpalern.dao.entity.OrderConsumer;
@Repository
public interface OrderRepository extends CrudRepository<OrderConsumer,Integer> {
}
