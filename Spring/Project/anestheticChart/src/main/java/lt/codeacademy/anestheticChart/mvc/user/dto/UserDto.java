package lt.codeacademy.anestheticChart.mvc.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String zipCode;
    private String phoneNumber;

}
