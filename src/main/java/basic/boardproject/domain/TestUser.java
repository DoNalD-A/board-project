package basic.boardproject.domain;

import basic.boardproject.dto.UserNewDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class TestUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String user_id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime created_date;

    //게시글 저장 시(Post)현재 시간을 자동으로 설정
    @PrePersist
    protected  void onCreate(){
        this.created_date = LocalDateTime.now();
    }

    public Users(UserNewDto userNewDto) {
        this.user_id = userNewDto.getUser_id();
        this.password = userNewDto.getPassword();
        this.email = userNewDto.getEmail();
    }
}

