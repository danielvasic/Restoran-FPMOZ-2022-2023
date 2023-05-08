package ba.sum.fpmoz.restoran.controller;

import ba.sum.fpmoz.restoran.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ba.sum.fpmoz.restoran.model.User;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @GetMapping("/register")
    public String register (Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register_user")
    public String register_user (User user, BindResult bind, Model model) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setRole("guest");
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("success", true);
        return "register";
    }
}
