package ru.lernup.springjpalern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.lernup.springjpalern.dao.AuthorDao;
import ru.lernup.springjpalern.dao.BookDao;
import ru.lernup.springjpalern.dao.BookStoreDao;
import ru.lernup.springjpalern.dao.ConsumerDao;
import ru.lernup.springjpalern.dao.data.*;

@SpringBootApplication
public class SpringJpaLernApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaLernApplication.class, args);
        BookDao dao = context.getBean(SpringDataBook.class);
//        bookStore.insertConsumer("Steve","22.01.2020");
//        bookStore.insertOrderToConsumer("Steve",105);
//        bookStore.insertDetailOrder(7,"Tree",5,19);
//        System.out.println(bookStore.getAllOrderToConsumer("Steve"));
//        System.out.println(bookStore.getAllBookConsumer("GreedOFRath"));
        BookStoreService bookStoreDao = context.getBean(BookStoreService.class);
        bookStoreDao.insertBook("Shopper","Yan",1999,5000,1000,
                "Yan");
        System.out.println(bookStoreDao.getAllBook());






    }

}
