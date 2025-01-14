package basic.boardproject.repository;

import basic.boardproject.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
}
