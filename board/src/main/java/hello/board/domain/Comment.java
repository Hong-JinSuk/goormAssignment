package hello.board.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comment extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String content; // 댓글 내용
    private String password; // 댓글 변경시 필요한 비밀번호

}
