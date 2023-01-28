package lk.ijse.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/nine")
public class ControllerNine {

    @GetMapping(produces ={MediaType.APPLICATION_JSON_VALUE})
    public String testOne() {
        return "test 1";
    }

    @GetMapping(consumes = {MediaType.TEXT_HTML_VALUE})
    public String testTwo() {
        return "test 2 - ";
    }
}
