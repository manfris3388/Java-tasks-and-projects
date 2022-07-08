package lt.codeacademy.anetheticChart.user.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anetheticChart.ChartEndPoints;
import lt.codeacademy.anetheticChart.user.dto.UserDto;
import lt.codeacademy.anetheticChart.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController implements ChartEndPoints {

    private final UserService userService;

    @GetMapping(ChartEndPoints.REGISTER_ROOT_PATH)
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
    return "user/user";
    }

    @PostMapping(ChartEndPoints.REGISTER_ROOT_PATH)
    public String register( UserDto userDto) {
        userService.register(userDto);
        return "redirect:" + ChartEndPoints.REGISTER_ROOT_PATH;
    }
}
