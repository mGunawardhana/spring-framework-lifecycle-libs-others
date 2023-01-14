package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Customer {

    public Customer(@Value("maneesha") String name) {
        System.out.println(name);
    }

    public Customer(@Value("Dinithi,Mendis,Maneesha,Gunawardhana") String[] names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
