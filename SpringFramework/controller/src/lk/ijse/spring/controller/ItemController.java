package lk.ijse.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/item")
public class ItemController {


    public ItemController() {
        System.out.println("ItemController Invoked !");
    }

    @GetMapping
    public ModelAndView test(){
        return new ModelAndView("/item");
    }

}
