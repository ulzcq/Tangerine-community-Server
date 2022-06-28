package yu.sixsense.tangerine.community.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yu.sixsense.tangerine.community.domain.Local;
import yu.sixsense.tangerine.community.domain.MarketPost;
import yu.sixsense.tangerine.community.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor//final이 있는 필드만 가지고 생성자를 생성
public class MarketPostRepository {

    public final EntityManager em;

    public void save(MarketPost marketPost){
        em.persist(marketPost);
    }

    public MarketPost findOne(Long pno){
        return em.find(MarketPost.class, pno);
    }

    public List<MarketPost> findByMember(Member member){
        return em.createQuery("select mp from MarketPost mp where mp.writer = :member", MarketPost.class)
                .setParameter("member", member)
                .getResultList();
    }

    public List<MarketPost> findByLocal(int localCode){
        return em.createQuery("select mp from MarketPost mp where mp.localCode = :localCode", MarketPost.class)
                .setParameter("localCode", localCode)
                .getResultList();
    }
}
