package ru.lernup.springjpalern.dao;

import ru.lernup.springjpalern.dao.entity.Consumer;

import java.util.List;

public interface ConsumerDao {
    List<Consumer> getAll();
    Consumer getById(int id);
    void save(Consumer consumer);
    Consumer getByName(String name);
}
