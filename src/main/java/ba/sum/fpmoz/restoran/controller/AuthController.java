package ba.sum.fpmoz.restoran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ba.sum.fpmoz.restoran.model.User;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @GetMapping("/register")
    public String register (Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
}
