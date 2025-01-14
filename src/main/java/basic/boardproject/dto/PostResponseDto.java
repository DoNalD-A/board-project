package basic.boardproject.dto;

import basic.boardproject.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostResponseDto {
    private String title;
    private String content;
    private LocalDateTime created_date;


    public PostResponseDto(Posts posts) {
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.created_date = posts.getCreated_date();
    }
}
