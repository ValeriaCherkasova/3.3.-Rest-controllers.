package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.model.User;
import project.service.UserServiceImp;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserServiceImp userService;

    @Autowired
    public UserController(UserServiceImp userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping("/user")
    public String userPage(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}