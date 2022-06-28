package yu.sixsense.tangerine.community.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yu.sixsense.tangerine.community.domain.Member;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    public final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
}
