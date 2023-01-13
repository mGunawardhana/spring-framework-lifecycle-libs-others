package lk.ijse.spring.pojo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GirlTwo implements GoodGirl {
    public GirlTwo() {
        System.out.println("Girl Two:Instantiated");
    }

    @Override
    public void chat() {
        System.out.println("Girl Two:Hello hello haai");
    }


}
