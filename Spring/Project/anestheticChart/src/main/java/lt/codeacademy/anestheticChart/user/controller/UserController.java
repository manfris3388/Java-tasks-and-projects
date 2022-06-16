package lt.codeacademy.anestheticChart.user.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.user.dto.UserDto;
import lt.codeacademy.anestheticChart.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
    return "user";
    }

    @PostMapping("/register")
    public String register( UserDto userDto) {
        userService.register(userDto);
        return "redirect:/users/register";
    }
}
