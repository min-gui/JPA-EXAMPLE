package hellojpa.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Embedded
    private Address address;

    //example .. 관계를 끊어 주는게 좋아.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

//    @Column(name = "team_id")
//    private Long teamId;


}
