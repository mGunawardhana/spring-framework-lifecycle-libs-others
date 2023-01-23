package lk.ijse.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seven")
public class ControllerSeven {

/*
    query string parameters
    http://localhost:8080/mapping_spec/seven/?id=C001&name=mGunawardhana
*/

    @GetMapping(params = {"id", "name"})
    public String testOne() {
        return "test 1";
    }

/*
    @GetMapping(params = {"address", "salary"})
    public String testTwo(HttpServletRequest request) {
        String address = request.getParameter("address");
        System.out.println(address);
        return "test 2 - " + address ;
    }
*/

    @GetMapping(params = {"address", "salary"})
    public String testTwo(@RequestParam String address, @RequestParam String salary) {
        return "test 2 - " + address + " " + salary;
    }


}
