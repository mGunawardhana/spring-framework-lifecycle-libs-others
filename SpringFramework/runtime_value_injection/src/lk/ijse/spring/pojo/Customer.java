package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Customer {
    public Customer(String name) {
        System.out.println("Customer : Instantiated !");
    }
}
