package basic.boardproject.domain;

import basic.boardproject.dto.PostNewResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime created_date;

    //게시글 저장 시(Post)현재 시간을 자동으로 설정
    @PrePersist
    protected  void onCreate(){
        this.created_date = LocalDateTime.now();
    }

    public Posts(PostNewResponseDto postNewResponseDto) {
        this.title = postNewResponseDto.getTitle();
        this.content = postNewResponseDto.getContent();
    }
}
