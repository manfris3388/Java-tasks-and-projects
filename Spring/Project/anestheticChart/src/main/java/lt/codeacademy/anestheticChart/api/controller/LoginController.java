package lt.codeacademy.anestheticChart.api.controller;

import lt.codeacademy.anestheticChart.api.dto.LoginResponse;
import lt.codeacademy.anestheticChart.commons.swagger.OpenApi;
import lt.codeacademy.anestheticChart.mvc.user.dto.UserRoleDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@OpenApi
public class LoginController {

    @PostMapping
    public LoginResponse login(@AuthenticationPrincipal UserRoleDto userRoleDto) {
        return new LoginResponse(userRoleDto);
    }
}
