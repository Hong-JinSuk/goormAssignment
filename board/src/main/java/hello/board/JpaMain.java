package hello.board;

import hello.board.domain.Comment;
import hello.board.domain.Post;
import hello.board.domain.User;
import hello.board.service.PostService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            // code®

            PostService postService = new PostService(em);
            User user = new User();
            em.persist(user);

            Post post = new Post();
            post.setCreatedBy("user1");
            post.setPostName("first Post");
            post.setPostContent("myPostContent");

            em.persist(post);
            tx.commit();

            tx.begin();

//            postService.deletePostById(post.getPostId());
            post.setPostContent("updateContent");
            em.persist(post);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
