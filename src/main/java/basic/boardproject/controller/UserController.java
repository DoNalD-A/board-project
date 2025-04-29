package basic.boardproject.controller;

import basic.boardproject.dto.UserNewDto;
import basic.boardproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signUp() {
        return "signUp";
    }

    //유저 생성 API(?)
    @PostMapping("/user/save")
    public String userSave(@RequestParam String user_id,
                           @RequestParam String password,
                           @RequestParam String email) {
        UserNewDto userNewDto = new UserNewDto(user_id, password, email);
        userService.userSave(userNewDto);

        return "redirect:/";
    }

}
