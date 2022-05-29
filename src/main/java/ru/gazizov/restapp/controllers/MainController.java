package ru.gazizov.restapp.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gazizov.restapp.model.User;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(
            @AuthenticationPrincipal User user,
            Model model){

        HashMap<Object, Object> data = new HashMap<>();
        data.put("profile", user);
        data.put("messages", null);
        model.addAttribute("frontendData", data);
        return "index";
    }
}
