package yu.sixsense.tangerine.community.api;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yu.sixsense.tangerine.community.domain.MarketPost;
import yu.sixsense.tangerine.community.domain.Member;
import yu.sixsense.tangerine.community.service.MarketPostService;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MarketPostApiController {

    private final MarketPostService marketPostService;

    /**
     *  장터글 등록 API
     */
    @PostMapping("/api/marketposts")
    public CreateMarketResponse createMarketPost(@RequestBody @Valid CreateMarketRequest request){

        //TODO: setter 쓰지말랬는데 이부분 어떻게 해야하는걸까..
        Member writer = new Member();
        writer.setId(request.getMemberId());

        MarketPost marketPost = new MarketPost(
                writer,
                request.getLocalCode(),
                request.getTitle(),
                request.getPrice(),
                request.getDescription(),
                request.getDate(),
                request.getImage()
        );

        Long id = marketPostService.createPost(marketPost);

        return new CreateMarketResponse(id);
    }

    @Data
    static class CreateMarketRequest{
        private Long memberId; //작성자
        private int localCode; //동네
        private String title; //제목
        private int price; //가격
        private String description; //내용
        private LocalDateTime date; //날짜
        private String image; //이미지 경로
    }

    @Data
    static class CreateMarketResponse{
        private Long id;

        public CreateMarketResponse(Long id) {
            this.id = id;
        }
    }
}
