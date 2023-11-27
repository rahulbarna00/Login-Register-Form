package com.example.server;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class welcome {
    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    boolean authenticate(String username, String password){
        return username.equals("username") && password.equals("password");
    }

    @RequestMapping(value = "/api/login", method = {RequestMethod.POST})
    public int login(@RequestBody(required = true) LoginRequest loginRequest) {
        if(authenticate(loginRequest.getUsername(), loginRequest.getPassword())){
            return 1;
        }
        else {
            return 0;
        }
    }

    @RequestMapping(value = "/api/login", method = {RequestMethod.GET})
    public String error(){
        return "Not Authorizes to access this page";
    }
}
