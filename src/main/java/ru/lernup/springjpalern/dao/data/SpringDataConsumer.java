package ru.lernup.springjpalern.dao.data;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import ru.lernup.springjpalern.dao.ConsumerDao;
import ru.lernup.springjpalern.dao.entity.Consumer;
import ru.lernup.springjpalern.repository.ConsumerRepository;

import java.util.ArrayList;
import java.util.List;
@Component
public class SpringDataConsumer implements ConsumerDao {
    private final ConsumerRepository consumerRepository;

    public SpringDataConsumer(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    @Override
    public List<Consumer> getAll() {
        List<Consumer> allConsumer = new ArrayList<>();
        consumerRepository.findAll().forEach(allConsumer::add);
        return allConsumer;
    }

    @Override
    public Consumer getById(int id) {
        return consumerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void save(Consumer consumer) {
  consumerRepository.save(consumer);
    }

    @Override
    public Consumer getByName(String name) {
        return consumerRepository.findConsumerByAllNameConsumer(name);
    }
}
