package basic.boardproject.dto;

import basic.boardproject.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostModifyDto {
    private Long id;
    private String title;
    private String content;

    public PostModifyDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
    }

}
