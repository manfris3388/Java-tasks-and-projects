package lt.codeacademy.anestheticChart.user.controller;

import lt.codeacademy.anestheticChart.user.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
    return "user";
    }

    @PostMapping("/register")
    public String register() {
        return "redirect:/user";
    }
}
