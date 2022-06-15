//package lt.codeacademy.anestheticChart.user.service;
//
//import lombok.RequiredArgsConstructor;
//import lt.codeacademy.anestheticChart.user.dto.UserDto;
//import lt.codeacademy.anestheticChart.user.entity.User;
//import lt.codeacademy.anestheticChart.user.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//
//    public void register(UserDto userDto) {
//        userRepository.save(User.builder()
//                .email(userDto.getEmail())
//                .name(userDto.getName())
//                .surname(userDto.getSurname())
//                .password(userDto.getPassword()) //FIXME: do not save as plain text, for security reason!!!!
//                .phoneNumber(userDto.getPhoneNumber())
//                .zipCode(userDto.getZipCode())
//                .build());
//    }
//}
