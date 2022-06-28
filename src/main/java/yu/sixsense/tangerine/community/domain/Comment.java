package yu.sixsense.tangerine.community.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자 막기
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_no")
    private Long cno;

    @ManyToOne
    @JoinColumn(name = "bbs_no")
    private MarketPost marketPost;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @NotNull
    private String description;

    @NotNull
    private LocalDateTime date;

    public Comment(MarketPost marketPost, Member writer, String description, LocalDateTime date) {
        this.marketPost = marketPost;
        this.writer = writer;
        this.description = description;
        this.date = date;
    }
}
