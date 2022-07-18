package lt.codeacademy.anestheticChart.mvc.user.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.mvc.user.dto.UserDto;
import lt.codeacademy.anestheticChart.jpa.entity.user_mvc.User;
import lt.codeacademy.anestheticChart.mvc.user.mapper.UserRoleMapper;
import lt.codeacademy.anestheticChart.jpa.repositories.user_mvc.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;
  private final UserRoleMapper userRoleMapper;

  public void register(UserDto userDto) {
    userRepository.save(
        User.builder()
            .email(userDto.getEmail())
            .name(userDto.getName())
            .surname(userDto.getSurname())
            .password(userDto.getPassword())
            .phoneNumber(userDto.getPhoneNumber())
            .zipCode(userDto.getZipCode())
            .build());
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findUserByEmailWithAuthorities(username)
            .map(userRoleMapper::mapToUserRoleDto)
            .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
  }
}
