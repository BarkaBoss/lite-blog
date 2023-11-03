package ng.com.nokt.liteblog.services;

import ng.com.nokt.liteblog.domain.Blog;
import ng.com.nokt.liteblog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;
    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog) {
        Optional<Blog> optional = this.blogRepository.findById(blog.getId());
        if(optional.isPresent()){
            Blog updateBlog = optional.get();

            updateBlog.setTitle(blog.getTitle());
            updateBlog.setBody(blog.getBody());
            updateBlog.setUpdatedAt(Date.from(Instant.now()).toString());

            blogRepository.save(updateBlog);
            return updateBlog;
        }else {
            throw new RuntimeException("There is no blog post with this ID");
        }
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(long id) {
        Optional<Blog> optional = blogRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }else {
            throw new RuntimeException("Blog Not Found");
        }
    }

    @Override
    public void deleteBlog(Blog blog) {
        Optional<Blog> optional = this.blogRepository.findById(blog.getId());
        if (optional.isPresent()){
            this.blogRepository.deleteById(blog.getId());
        }else {
            throw new RuntimeException("No Blog with this ID");
        }
    }
}
