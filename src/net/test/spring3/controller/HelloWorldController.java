package net.test.spring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloWorldController {
 
    @RequestMapping("/hello")
    public ModelAndView helloWorld() {
 
        String message = "test";
        return new ModelAndView("hello", "message", message);
    }
    
}