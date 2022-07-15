package lt.codeacademy.anestheticChart.mvc.user.mapper;

import lt.codeacademy.anestheticChart.mvc.user.dto.UserDto;
import lt.codeacademy.anestheticChart.jpa.entity.user_mvc.User;
import lt.codeacademy.anestheticChart.mvc.user.dto.UserRoleDto;
import lt.codeacademy.anestheticChart.jpa.entity.user_mvc.Authority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class UserRoleMapper {

    public UserRoleDto mapToUserRoleDto(User userEntity) {
        return UserRoleDto.builder()
                .user(UserDto.builder()
                        .email(userEntity.getEmail())
                        .name(userEntity.getName())
                        .surname(userEntity.getSurname())
                        .password(userEntity.getPassword())
                        .repeatedPassword(userEntity.getRepeatedPassword())
                        .phoneNumber(userEntity.getPhoneNumber())
                        .zipCode(userEntity.getZipCode())
                        .build())
                .roles(
                        userEntity.getAuthorities().stream()
                                .map(getAuthority())
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toUnmodifiableSet())
                )
                .build();
    }

    private Function<Authority, String> getAuthority() {
        return authority -> "ROLE_" + authority.getName();
    }
}
