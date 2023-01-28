package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/nine")
public class ControllerNine {

    @GetMapping()
    public String testOne() {
        return "test 1";
    }

    @GetMapping(consumes = {})
    public String testTwo() {
        return "test 2 - ";
    }
}
