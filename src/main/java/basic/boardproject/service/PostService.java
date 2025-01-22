package basic.boardproject.service;

import basic.boardproject.domain.Posts;
import basic.boardproject.dto.PostNewResponseDto;
import basic.boardproject.dto.PostResponseAllDto;
import basic.boardproject.dto.PostResponseOneDto;
import basic.boardproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseAllDto> findAll() {
        /*
        * List<Posts>를 postRepostiory.findAll()로 찾기
        * List<Posts>를 List<PostResponseDto>로 수정하여 반환하기*/
        List<Posts> postsList = postRepository.findAll();
        List<PostResponseAllDto> postResponseAllDtoList = postsList.stream()
                .map(PostResponseAllDto::new)
                .toList();

        return postResponseAllDtoList;
    }

    public PostResponseOneDto findById(Long id) {
//        Posts posts = postRepository.findById(id);
        Optional<Posts> posts = postRepository.findById(id);
        if (!posts.isPresent()) {
            throw new IllegalArgumentException();
        }
        PostResponseOneDto postResponseOneDto = new PostResponseOneDto(posts.get());
        return postResponseOneDto;
//        return new PostResponseOneDto(posts.get());
    }

    public void save(PostNewResponseDto postNewResponseDto) {
        Posts posts = new Posts(postNewResponseDto);
        postRepository.save(posts);
    }
}
