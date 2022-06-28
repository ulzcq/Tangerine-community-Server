package yu.sixsense.tangerine.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.sixsense.tangerine.community.domain.Comment;
import yu.sixsense.tangerine.community.domain.MarketPost;
import yu.sixsense.tangerine.community.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    /**
     * 댓글 등록
     * @param comment
     * @return Long
     */
    @Transactional
    public Long createComment(Comment comment){
        commentRepository.save(comment);
        return comment.getCno();
    }

    /**
     * 댓글 조회(해당 포스트의 댓글 리스트)
     *  TODO: 페이징
     */
    @Transactional(readOnly = true)
    public List<Comment> findByPost(MarketPost marketPost){
        return commentRepository.findByPost(marketPost);
    }
}