package lt.codeacademy.anestheticChart.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("login-chart")
    public String openLoginPage() {
        return "login";
    }
}
