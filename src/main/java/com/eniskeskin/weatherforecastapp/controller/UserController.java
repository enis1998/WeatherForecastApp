package com.eniskeskin.weatherforecastapp.controller;

import com.eniskeskin.weatherforecastapp.dao.UserRepository;
import com.eniskeskin.weatherforecastapp.entity.UserProfile;
import com.eniskeskin.weatherforecastapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("user", new UserProfile());
        return "signup.html";
    }
    @PostMapping("/signup")
    public String signUpSubmit(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("password2") String password2) {
        boolean ok = userService.saveUser(email, password, password2);

        if (ok == false) {
            return "redirect:/signup";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login.html";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam("email") String email, @RequestParam("password") String password) {
        boolean ok = userService.loginCheck(email, password);
        if (ok == true) {
            return "redirect:/main";
        }
        return "redirect:/login";
    }

    @GetMapping("/main")
    public String mainPage() {
        return "main.html";
    }
}
