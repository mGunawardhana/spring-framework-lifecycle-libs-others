package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class PojoThree implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public PojoThree(){
        System.out.println("PojoThree:Instantiated");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoThree:BeanName Aware : "+name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoThree:BeanFactory Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoThree:Application Context Aware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoThree:Initializing Bean: Bean is Ready for USE");
        System.out.println("==================");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PojoThree:Destroyed");
    }
}
