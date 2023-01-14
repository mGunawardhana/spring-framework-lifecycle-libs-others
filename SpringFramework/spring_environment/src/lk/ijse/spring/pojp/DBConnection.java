package lk.ijse.spring.pojp;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DBConnection implements InitializingBean {

    @Value("${OS}")
    private String myOSName;

    public DBConnection() {
        System.out.println("DBConnection : Instantiated !");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(myOSName);
    }
}
