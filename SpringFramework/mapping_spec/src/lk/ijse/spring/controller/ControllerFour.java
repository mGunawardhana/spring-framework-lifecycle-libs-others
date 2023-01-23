package lk.ijse.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/four")
public class ControllerFour {

    /*

     Character mapping
     http://localhost:8080/mapping_spec/C1DEF

     */

    @GetMapping(path = "/C?DEF")
    public String testOne(){
        return "character mapping invoked !";
    }

    @GetMapping(path = "/C?????DEF")
    public String testOne_A(){
        return "character test_one_A mapping invoked !";
    }

}
