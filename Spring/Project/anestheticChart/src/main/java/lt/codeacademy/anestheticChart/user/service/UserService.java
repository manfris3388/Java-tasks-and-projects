package lt.codeacademy.anestheticChart.user.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.user.dto.UserDto;
import lt.codeacademy.anestheticChart.user.entity.User;
import lt.codeacademy.anestheticChart.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;

  public void register(UserDto userDto) {
    userRepository.save(
        User.builder()
            .email(userDto.getEmail())
            .name(userDto.getName())
            .surname(userDto.getSurname())
            .password(userDto.getPassword())
            .repeatedPassword(userDto.getRepeatedPassword()) // FIXME: do not save as plain text, for security reason!!!!
            .phoneNumber(userDto.getPhoneNumber())
            .zipCode(userDto.getZipCode())
            .build());
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findUserByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));
  }
}
