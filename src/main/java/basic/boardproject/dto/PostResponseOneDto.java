package basic.boardproject.dto;

import basic.boardproject.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostResponseOneDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_date;

    public PostResponseOneDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.created_date = posts.getCreated_date();
    }
}
