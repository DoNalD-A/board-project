package basic.boardproject.controller;

import basic.boardproject.dto.*;
import basic.boardproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    //모든 게시글 조회
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

    //게시글 1개 조회
    @GetMapping("/article/{id}")
    public String article(@PathVariable Long id, Model model) {
        PostResponseOneDto postResponseOneDto = postService.findById(id);
        model.addAttribute("posts", postResponseOneDto);

        return "article";
    }

    //게시글 생성
    @GetMapping("/newArticle")
    public String newArticle() {
        return "newArticle";
    }

    //게시글 생성 API (?)
    @PostMapping("/newArticle")
    public String postNewArticle(@RequestParam String title, String content) {
        PostNewResponseDto postNewResponseDto = new PostNewResponseDto(title, content);
        postService.save(postNewResponseDto);

        return "redirect:/";
    }

    //게시글 수정
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

    //게시글 수정 API(?)
    @PostMapping("/modifyArticle")
    public String postModifyArticle(@RequestParam Long id,
                                    @RequestParam String title,
                                    @RequestParam String content) {
        PostModifyDto postModifyDto = new PostModifyDto(id, title, content);
//        Posts posts = postService.update(id, postModifyDto);
        postService.update(id, postModifyDto);

        return "redirect:/";
    }

    //게시글 삭제 API(?)
    @PostMapping("/deleteArticle")
    public String deleteArticle(@RequestParam Long id) {
        postService.deleteById(id);
        return "redirect:/";
    }

    //'고양이 아이콘 클릭' -> 행운고양이 페이지
    @GetMapping("/luckyCat")
    public String luckyCat() {
        return "luckyCat";
    }

}
