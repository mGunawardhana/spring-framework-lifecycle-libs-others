package lk.ijse.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ten")
public class ControllerTen {

    @GetMapping(headers = {"Content-Type=application/json","Accept=text/html"})
    public String testOne() {
        return "test 1";
    }

}
