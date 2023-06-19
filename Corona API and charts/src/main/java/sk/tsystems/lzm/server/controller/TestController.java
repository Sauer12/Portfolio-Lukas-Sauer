package sk.tsystems.lzm.server.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    public String test = "test";

    @RequestMapping
    public String processUserInput(){
        getText();
        return ("test");
    }

    public void getText(){
        if(test.equals("test"))
            test = "ahoj";
        else
            test = "test";

    }
}
