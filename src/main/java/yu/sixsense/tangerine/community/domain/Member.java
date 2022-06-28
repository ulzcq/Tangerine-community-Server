package yu.sixsense.tangerine.community.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본생성자 막기
public class Member {

    @Id  //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    @NotNull
    private Long id;

    @NotNull
    private String name;

    private int localCode; //우야지... 흠
    private String profileImage; //이미지 경로


    public Member(){}

    public Member(Long id, int localCode, String name, String profileImage) {
        this.id = id;
        this.localCode = localCode;
        this.name = name;
        this.profileImage = profileImage;
    }

    public void updateLocal(int localCode){
        this.localCode = localCode;
    }
}
