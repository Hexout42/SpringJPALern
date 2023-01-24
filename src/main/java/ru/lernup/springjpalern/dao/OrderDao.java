package ru.lernup.springjpalern.dao;

import ru.lernup.springjpalern.dao.entity.OrderConsumer;

import java.util.List;

public interface OrderDao {
    List<OrderConsumer> getAll();
    OrderConsumer getById(int id);
    void save(OrderConsumer orderConsumer);
    void  deleteByID(int id);
}
