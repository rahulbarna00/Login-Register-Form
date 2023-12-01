package com.example.reactspringbootmysql.Controller;

import com.example.reactspringbootmysql.model.User;
import com.example.reactspringbootmysql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add")
    @ResponseBody
    public String addUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepo.save(user);
        return "saved";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password) {
        // Retrieve user by username
        User user = userRepo.findByUsername(username);

        // Check if the user exists and the password matches
        if (user != null && user.getPassword().equals(password)) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepo.findAll();
    }
}
