package ru.lernup.springjpalern.dao.data;

import org.springframework.stereotype.Service;
import ru.lernup.springjpalern.dao.entity.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringBookStore {
    private final SpringDataAuthor author;
    private final SpringDataBook book;
    private final SpringDataEmployee employee;
    private final SpringDataOrder order;
    private final SpringDataConsumer consumer;

    public SpringBookStore(SpringDataAuthor author, SpringDataBook book,
                           SpringDataEmployee employee, SpringDataOrder order,
                           SpringDataConsumer consumer) {
        this.author = author;
        this.book = book;
        this.employee = employee;
        this.order = order;
        this.consumer = consumer;
    }
    public Author getAuthor(Long id){
        return author.getById(id);
    }

    public void insertConsumer(String name, String birthDate){
        Consumer consumer1 = new Consumer();
        consumer1.setAllNameConsumer(name);
        consumer1.setBirthDate(birthDate);
        consumer1.setOrderConsumer(new ArrayList<>());
        consumer.save(consumer1);
    }
    public void insertOrderToConsumer(String name,int cost){
        OrderConsumer orderConsumer = new OrderConsumer();
       Consumer consumer1 = consumer.getByName(name);
        orderConsumer.setConsumer(consumer1);
        orderConsumer.setCost(cost);
        consumer1.getOrderConsumer().add(orderConsumer);
        order.save(orderConsumer);

    }
    public List<OrderConsumer> getAllOrderToConsumer(String name){
        return  consumer.getByName(name).getOrderConsumer();
    }
    public Consumer getConsumerByName(String name){
        return consumer.getByName(name);
    }
    public List<Book> getAllBookConsumer(String name){
        List<Book> books = new ArrayList<>();
        Consumer consumer1 = consumer.getByName(name);
        consumer1.getOrderConsumer().forEach(cons ->{
            cons.getDetailsOrders().forEach(detailsOrder -> {
                books.add(detailsOrder.getIdBook());
            });
        });

        return books;
    }
    public void insertDetailOrder(int idOrder,String name,int quantity,int idEmployee){
        OrderConsumer orderConsumer = order.getById(idOrder);
        order.deleteByID(orderConsumer.getId());
        DetailsOrder detailsOrder = new DetailsOrder();
        detailsOrder.setIdBook(book.findBookByNameBook(name));
        detailsOrder.setQuantity(quantity);
        detailsOrder.setIdOrder(orderConsumer);
        detailsOrder.setIdEmployee(employee.getById(idEmployee));
        orderConsumer.getDetailsOrders().add(detailsOrder);
        order.save(orderConsumer);
    }
}
