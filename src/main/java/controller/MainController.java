package controller;

import config.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    public static ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String showError() {
        return "error";
    }
}
