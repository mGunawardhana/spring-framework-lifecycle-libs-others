package lk.ijse.spring.pojp;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {
    public DBConnection() {
        System.out.println("DBConnection : Instantiated !");
    }
}
