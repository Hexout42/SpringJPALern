package ru.lernup.springjpalern.dao.data;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import ru.lernup.springjpalern.dao.OrderDao;
import ru.lernup.springjpalern.dao.entity.OrderConsumer;
import ru.lernup.springjpalern.repository.OrderRepository;

import java.util.List;
@Component
public class SpringDataOrder implements OrderDao {
    private final OrderRepository orderRepository;

    public SpringDataOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderConsumer> getAll() {
        return null;
    }

    @Override
    public OrderConsumer getById(int id) {
        return orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void save(OrderConsumer orderConsumer) {
       orderRepository.save(orderConsumer);
    }

    @Override
    public void deleteByID(int id) {

    }
}
