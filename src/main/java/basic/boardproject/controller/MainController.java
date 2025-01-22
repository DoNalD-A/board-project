package basic.boardproject.controller;

import basic.boardproject.dto.PostResponseAllDto;
import basic.boardproject.dto.PostResponseOneDto;
import basic.boardproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        List<PostResponseAllDto> postResponseAllDtoList = postService.findAll();
        model.addAttribute("posts", postResponseAllDtoList);
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

    @GetMapping("/article/{id}")
    public String article(@PathVariable Long id, Model model) {
        PostResponseOneDto postResponseOneDto = postService.findById(id);
        model.addAttribute("posts", postResponseOneDto);

        return "article";

    }

}
