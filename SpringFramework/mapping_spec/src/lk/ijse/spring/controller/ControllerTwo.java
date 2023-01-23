package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/two")
public class ControllerTwo {
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

    @GetMapping(path = "/c")
    public String testFour() {
        return "get method invoked by method Four";
    }

    @GetMapping(path = "/d")
    public String testFive() {
        return "get method invoked by method Five";
    }

    @GetMapping(path = "/e")
    public String testSix() {
        return "get method invoked by method Six";
    }

}
