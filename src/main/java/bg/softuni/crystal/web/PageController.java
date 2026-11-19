package bg.softuni.crystal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping({"/menu", "/products"})
    public String menu() {
        return "products";
    }
    @GetMapping({"/visit", "/store"})
    public String visit() {
        return "store";
    }
}
