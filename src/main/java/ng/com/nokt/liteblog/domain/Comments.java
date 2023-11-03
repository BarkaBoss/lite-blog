package ng.com.nokt.liteblog.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity(name = "comments")
public class Comments {

    @Id
    private Long id;

    @NonNull
    private String comment;

    @NonNull
    private String userId;

    @OneToMany
    List<Likes> likes;
}
