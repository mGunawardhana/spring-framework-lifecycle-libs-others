package lk.ijse.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/three")
public class ControllerThree {
    @GetMapping
    public String testOne() {
        return "get method invoked";
    }

    @GetMapping(path = "/a/b")
    public String testTwo() {
        return "get method invoked by method two";
    }

    @GetMapping(path = "/b")
    public String testThree() {
        return "get method invoked by method Three";
    }
}
