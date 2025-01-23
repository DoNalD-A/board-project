package basic.boardproject.service;

import basic.boardproject.domain.Users;
import basic.boardproject.dto.UserNewDto;
import basic.boardproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    //유저 생성
    public void userSave(UserNewDto userNewDto) {
        Users users = new Users(userNewDto);
        if (userRepository.existsById(users.getId())) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
        userRepository.save(users);
    }
}
