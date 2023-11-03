package ng.com.nokt.liteblog.api;

import ng.com.nokt.liteblog.domain.Blog;
import ng.com.nokt.liteblog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/blog")
    @GetMapping("/blog")
    ResponseEntity<List<Blog>> getAllBlogs(){
        return ResponseEntity.ok().body(blogService.getAllBlog());
    }

    @GetMapping("/blog{id}")
    ResponseEntity<Blog> getBlogById(@PathVariable Long id){
        return ResponseEntity.ok().body(blogService.getBlogById(id));
    }

    @RequestMapping
    @PutMapping
    ResponseEntity<Blog> updateBlog(@PathVariable Blog blog){
        return ResponseEntity.ok().body(blogService.updateBlog(blog));
    }


}
