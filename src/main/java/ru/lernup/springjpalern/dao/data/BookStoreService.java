package ru.lernup.springjpalern.dao.data;


import org.springframework.stereotype.Service;
import ru.lernup.springjpalern.dao.entity.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookStoreService {
    private final SpringDataAuthor author;
    private final SpringDataBook book;
    private final SpringDataEmployee employee;
    private final SpringDataOrder order;
    private final SpringDataConsumer consumer;
    private final SpringDataBookStore bookStore;

    public BookStoreService(SpringDataAuthor author, SpringDataBook book,
                            SpringDataEmployee employee, SpringDataOrder order,
                            SpringDataConsumer consumer,
                             SpringDataBookStore bookStore) {
        this.author = author;
        this.book = book;
        this.employee = employee;
        this.order = order;
        this.consumer = consumer;
        this.bookStore = bookStore;

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
    public void insertOrderToConsumer(String name,int cost,long idStore){
        OrderConsumer orderConsumer = new OrderConsumer();
        Consumer consumer1 = consumer.getByName(name);
        orderConsumer.setConsumer(consumer1);
        orderConsumer.setCost(cost);
        orderConsumer.setIdStore(bookStore.getStoreById(idStore));
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
    public void insertBook(String nameStore, String name, int age,int numOfPg,int price,String nameAuthor){
        Book book1 = new Book();
        book1.setNameBook(name);
        book1.setAgeBook(age);
        book1.setPriceBook(price);
        book1.setNumberOfPages(numOfPg);
        bookStore.getStoreByName(nameStore).getBookList().add(book1);
        book1.setIdStore(bookStore.getStoreByName(nameStore));
        author.getByName(nameAuthor).getBooks().add(book1);
        book1.setIdAuthor(author.getByName(nameAuthor));
        book.save(book1);
    }
    public List<Book> getAllBook(){
        return bookStore.getAllBook();
    }
}