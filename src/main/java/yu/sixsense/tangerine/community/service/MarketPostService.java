package yu.sixsense.tangerine.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.sixsense.tangerine.community.domain.MarketPost;
import yu.sixsense.tangerine.community.domain.Member;
import yu.sixsense.tangerine.community.repository.MarketPostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketPostService {

    private final MarketPostRepository marketPostRepository;

    //TODO: 첨부파일 업로드
    /**
     * 장터글 작성
     * @param marketPost
     * @return Long
     */
    @Transactional
    public Long createPost(MarketPost marketPost){
        marketPostRepository.save(marketPost);
        return marketPost.getPno();
    }

    /**
     * 장터글 조회
     * @param pno
     * @return MarketPost
     */
    @Transactional(readOnly = true)
    public MarketPost findOne(Long pno){
        return marketPostRepository.findOne(pno);
    }

    /**
     * 장터 글목록 조회
     * @param localCode (동 지역코드에 따라 게시판 구분)
     * @return List<MarketPost>
     */
    @Transactional(readOnly = true)
    public List<MarketPost> findMarketPosts(int localCode){
        //TODO: 페이징
        return marketPostRepository.findByLocal(localCode);
    }

    /**
     * 내가 쓴 글목록 조회
     * @param member
     * @return List<MarketPost>
     */
    @Transactional(readOnly = true)
    public List<MarketPost> findByMember(Member member){
        return marketPostRepository.findByMember(member);
    }

}
