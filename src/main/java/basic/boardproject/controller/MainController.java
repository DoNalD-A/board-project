package basic.boardproject.controller;

import basic.boardproject.dto.PostResponseDto;
import basic.boardproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        List<PostResponseDto> postResponseDtoList = postService.findAll();
        model.addAttribute("posts", postResponseDtoList);
        /*
         * 서비스에 넘겨서 리스트로 받아오기
         * 모델에 담기
         * 반환하기*/

        return "articleList";
    }

    @GetMapping("/article")
    public String article() {
        return "article";
    }

    @GetMapping("/articletmp")
    public String articletmp() {
        return "articletmp";
    }

}
