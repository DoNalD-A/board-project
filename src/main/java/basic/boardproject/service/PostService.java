package basic.boardproject.service;

import basic.boardproject.domain.Posts;
import basic.boardproject.dto.PostResponseDto;
import basic.boardproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseDto> findAll() {
        /*
        * List<Posts>를 postRepostiory.findAll()로 찾기
        * List<Posts>를 List<PostResponseDto>로 수정하여 반환하기*/
        List<Posts> postsList = postRepository.findAll();
        List<PostResponseDto> postResponseDtoList = postsList.stream()
                .map(PostResponseDto::new)
                .toList();

        return postResponseDtoList;
    }
}
