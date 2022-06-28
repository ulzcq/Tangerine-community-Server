package yu.sixsense.tangerine.community.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yu.sixsense.tangerine.community.domain.Comment;
import yu.sixsense.tangerine.community.domain.MarketPost;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    public final EntityManager em;

    public void save(Comment comment){
        em.persist(comment);
    }

    //TODO: marketPost로 찾아야할지 pno로만 찾아도 될지..
    //TODO: Exception 터지면 try catch 짜야함 -> 나중에 spring data JPA로 리팩토링
    public List<Comment> findByPost(MarketPost marketPost){
        return em.createQuery("select c from Comment c where c.marketPost = :marketPost", Comment.class)
                .setParameter("marketPost", marketPost)
                .getResultList();
    }

    public Comment findOne(Long cno){
        return em.find(Comment.class, cno);
    }
}
