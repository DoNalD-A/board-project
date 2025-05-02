package basic.boardproject.service;

import basic.boardproject.domain.Posts;
import basic.boardproject.domain.Users;
import basic.boardproject.dto.*;
import basic.boardproject.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceTest {

    private final PostRepository postRepository;

    public List<PostResponseAllDto> findAll() {
        /*
         * List<Posts>를 postRepostiory.findAll()로 찾기
         * List<Posts>를 List<PostResponseDto>로 수정하여 반환하기*/
        //게시글 전체 조회
        List<Posts> postsList = postRepository.findAll();
        List<PostResponseAllDto> postResponseAllDtoList = postsList.stream()
                .map(PostResponseAllDto::new)
                .toList();

        return postResponseAllDtoList;
    }

    //게시글 1개 조회
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

    //게시글 생성
    public void save(PostNewResponseDto postNewResponseDto) {
        Posts posts = new Posts(postNewResponseDto);
        postRepository.save(posts);
    }

    //게시글 수정
    public PostModifyDto findByIdModify(Long id) {
        Optional<Posts> posts = postRepository.findById(id);
        if (!posts.isPresent()) {
            throw new IllegalArgumentException();
        }
        PostModifyDto postModifyDto = new PostModifyDto(posts.get());
        return postModifyDto;

    }

    //    @Transactional
//    public Posts update(long id, PostModifyDto postModifyDto) {
//        Posts posts = postRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
//
//        posts.update(postModifyDto.getTitle(), postModifyDto.getContent());
//        return posts;
//    }
    //게시글 수정
    public void update(Long id, PostModifyDto postModifyDto) {
        Posts post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID: " + id));

        // 수정된 데이터 적용
        post.setTitle(postModifyDto.getTitle());
        post.setContent(postModifyDto.getContent());

        // 저장
        postRepository.save(post);
    }

    //게시글 삭제
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }


}
