package ng.com.nokt.liteblog.services;

import ng.com.nokt.liteblog.domain.Blog;

import java.util.List;

public interface BlogService {

    void createBlog(Blog blog);
    Blog updateBlog(Blog blog);
    List<Blog> getAllBlog();
    Blog getBlogById(long id);
    void deleteBlog(Blog blog);
}
