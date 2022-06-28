package yu.sixsense.tangerine.community.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.sixsense.tangerine.community.domain.Member;
import yu.sixsense.tangerine.community.repository.MemberRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원등록
     */
    @Transactional
    public Long join(Member member){

        validateDuplicateMember(member); //중복 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //이미 DB에 카카오계정이 존재하는지 체크
        Member findMember = memberRepository.findOne(member.getId());

        if(findMember != null){
            throw new IllegalStateException("이미 등록된 계정입니다");
        } //TODO: 등록된 계정임을 알리는 Exception 생성해서 적용하기
    }

    /**
     *  로그인 : MVC2 강의 듣고 만들 것!
     */


    /**
     * 회원조회
     */
    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return  memberRepository.findOne(memberId);
    }

    /**
     * 회원 주소설정
     */
    @Transactional
    public Long updateLocal(Member member){
        Member findMember = memberRepository.findOne(member.getId());
        findMember.updateLocal(member.getLocalCode());
        return findMember.getId();
    }

}
