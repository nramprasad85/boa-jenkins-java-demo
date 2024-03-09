package io.akalabs.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class controller {
    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }
    
}
