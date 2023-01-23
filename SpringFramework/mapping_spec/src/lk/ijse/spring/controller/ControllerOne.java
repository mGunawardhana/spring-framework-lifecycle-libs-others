package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/one")
public class ControllerOne {

    @GetMapping
    public String testOne() {
        return "get method invoked";
    }

    @PostMapping
    public String testTwo() {
        return "post method invoked";
    }

    @PutMapping
    public String testThree() {
        return "put method invoked";
    }

    @DeleteMapping
    public String testFour() {
        return "delete method invoked";
    }
}
