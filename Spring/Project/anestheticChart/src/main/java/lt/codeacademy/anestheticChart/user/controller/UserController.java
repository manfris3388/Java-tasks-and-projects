package lt.codeacademy.anestheticChart.user.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.ChartEndPoints;
import lt.codeacademy.anestheticChart.user.dto.UserDto;
import lt.codeacademy.anestheticChart.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController implements ChartEndPoints {

    private final UserService userService;

    @GetMapping(REGISTER_ROOT_PATH)
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
    return "user/user";
    }

    @PostMapping(REGISTER_ROOT_PATH)
    public String register( UserDto userDto) {
        userService.register(userDto);
        return "redirect:" + REGISTER_ROOT_PATH;
    }
}
