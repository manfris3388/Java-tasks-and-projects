package lt.codeacademy.anestheticChart.api.service;

import lt.codeacademy.anestheticChart.mvc.user.dto.UserRoleDto;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    public String getToken(UserRoleDto principal) {
        return "My token: " + principal.getFullName();
    }
}
