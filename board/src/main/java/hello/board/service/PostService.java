package hello.board.service;

import hello.board.domain.Post;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class PostService {

    private EntityManager em;

    public PostService(EntityManager em) {
        this.em =em;
    }

    @Transactional
    public void deletePostById(Long postId) {
        Post post = em.find(Post.class, postId);
        if (post != null) {
            em.remove(post);
        }
    }
}
