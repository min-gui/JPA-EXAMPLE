package hellojpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") //반대편 사이트에 해당하는 변수명.
    private List<Member> members = new ArrayList<>(); //관례 add 할때 null 안뜬다.

    public void addMember(Member member){
        member.setTeam(this);
        members.add(member);
    }


}
