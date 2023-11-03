package ng.com.nokt.liteblog.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "likes")
public class Likes {

    @Id
    private Long id;

    private int numberOfLikes;
}
