package lk.ijse.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    public CustomerController() {
        System.out.println("CustomerController Invoked !");
    }

    @GetMapping
    public ModelAndView test(){
        return new ModelAndView("/customer");
    }

}
