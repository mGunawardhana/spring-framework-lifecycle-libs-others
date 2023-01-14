package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Customer {

    @Autowired(required = false)
    public Customer(@Value("maneesha") String name) {
        System.out.println(name);
    }

    @Autowired(required = false)
    public Customer(@Value("Dinithi,Mendis,Maneesha,Gunawardhana") String[] names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
