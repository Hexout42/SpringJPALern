package ru.lernup.springjpalern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.lernup.springjpalern.dao.AuthorDao;
import ru.lernup.springjpalern.dao.BookDao;
import ru.lernup.springjpalern.dao.ConsumerDao;
import ru.lernup.springjpalern.dao.data.SpringBookStore;
import ru.lernup.springjpalern.dao.data.SpringDataAuthor;
import ru.lernup.springjpalern.dao.data.SpringDataBook;
import ru.lernup.springjpalern.dao.data.SpringDataConsumer;

@SpringBootApplication
public class SpringJpaLernApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaLernApplication.class, args);
        BookDao dao = context.getBean(SpringDataBook.class);
        SpringBookStore bookStore = context.getBean(SpringBookStore.class);
//        bookStore.insertConsumer("Steve","22.01.2020");
//        bookStore.insertOrderToConsumer("Steve",105);
        bookStore.insertDetailOrder(7,"Tree",5,19);
        System.out.println(bookStore.getAllOrderToConsumer("Steve"));
        System.out.println(bookStore.getAllBookConsumer("GreedOFRath"));





    }

}
