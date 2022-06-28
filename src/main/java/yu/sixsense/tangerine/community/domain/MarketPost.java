package yu.sixsense.tangerine.community.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자 막기
public class MarketPost {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_no")
    private Long pno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private int localCode;

    @NotNull
    private String title;

    @NotNull
    private int price;

    @NotNull
    private String description;

    @NotNull
    private LocalDateTime date;

    private String image; //이미지 경로

    public MarketPost(Member member, int localCode, String title, int price, String description, LocalDateTime date, String image) {
        this.member = member;
        this.localCode = localCode;
        this.title = title;
        this.price = price;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    //== 비즈니스 로직==//
    /**
     *  장터글 수정
     * @param title
     * @param price
     * @param description
     * @param image
     */
    public void update(String title, int price, String description, String image){
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
    }
}
