package lk.ijse.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/five")
public class ControllerFive {

    @GetMapping(path = "/path/*/A/B")
    public String testOne(){
        return "test 1";
    }

    @GetMapping(path = "/**/path/A/C")
    public String testOne_A(){
        return "test 2 !";
    }

}
