package hellojpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Movie extends Item {

    String director;
    String actor;
}
