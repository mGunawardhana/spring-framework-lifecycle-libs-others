package lk.ijse.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/three")
public class ControllerThree {

    //http://localhost:8080/mapping_spec/three/id/C002/Maneesha

/*
    @GetMapping(path = "/id/{C001}/{gunawardhana}")
    public String testOne(@PathVariable("C001") String id, @PathVariable("gunawardhana") String name) {
        System.out.println(id + " " + name);
        return "get method invoked - controller 3 id: " + id + " name: " + name;
    }
*/

    @GetMapping(path = "/id/{id:[C]{1}[0-9]{3}}/{name}")
    public String testOne(@PathVariable String id, @PathVariable String name) {
        System.out.println(id + " " + name);
        return "get method invoked - controller 3 id: " + id + " name: " + name;
    }

    @GetMapping(path = "/id/{id:[C]{2}[0-9]{2}}/{name}")
    public String tesTwo(@PathVariable String id, @PathVariable String name) {
        System.out.println(id + " " + name);
        return "get method two invoked - controller 3 id: " + id + " name: " + name;
    }


}
