package basic.boardproject.controller;

import basic.boardproject.domain.Posts;
import basic.boardproject.dto.PostModifyDto;
import basic.boardproject.dto.PostNewResponseDto;
import basic.boardproject.dto.PostResponseAllDto;
import basic.boardproject.dto.PostResponseOneDto;
import basic.boardproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/newArticle")
    public String newArticle() {
        return "newArticle";
    }

    @PostMapping("/newArticle")
    public String postNewArticle(@RequestParam String title, String content) {
        PostNewResponseDto postNewResponseDto = new PostNewResponseDto(title, content);
        postService.save(postNewResponseDto);

        return "redirect:/";
    }

    @GetMapping("/modifyArticle")
    public String modifyArticle(@RequestParam Long id,
                                Model model) {
        PostModifyDto postModifyDto = postService.findByIdModify(id);
//        model.addAttribute("posts", postModifyDto);

        model.addAttribute("id", id);
        model.addAttribute("title", postModifyDto.getTitle());
        model.addAttribute("content", postModifyDto.getContent());

        return "modifyArticle";
    }

    @PostMapping("/modifyArticle")
    public String postModifyArticle(@RequestParam Long id,
                                    @RequestParam String title,
                                    @RequestParam String content) {
        PostModifyDto postModifyDto = new PostModifyDto(id, title, content);
//        Posts posts = postService.update(id, postModifyDto);
        postService.update(id, postModifyDto);

        return "redirect:/";
    }

    @PostMapping("/deleteArticle")
    public String deleteArticle(@RequestParam Long id) {
        postService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/luckyCat")
    public String luckyCat(){
        return "luckyCat";
    }
}
