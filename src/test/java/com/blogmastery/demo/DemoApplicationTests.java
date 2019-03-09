package com.blogmastery.demo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.blogmastery.demo.models.Author;
import com.blogmastery.demo.models.Post;
import com.blogmastery.demo.repositories.AuthorRepository;
import com.blogmastery.demo.repositories.PostRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class DemoApplicationTests {

		
	@Resource
	private TestEntityManager entityManager;
	 
	@Resource
	private PostRepository postRepo;
	
	@Resource
	private AuthorRepository authorRepo;
	
	
	@Test
    public void shouldSaveAndLoadPost() {
        Post post = postRepo.save(new Post("new blog", "This is my blog post", "Fry", "08 Mar 2019", "Sports", "Random"));
        Long postId = post.getId();
 
        entityManager.persist(post);
        entityManager.flush();
        entityManager.clear();
 
        Optional<Post> postToFind = postRepo.findById(postId);
        post = postToFind.get();
 
        assertThat(post.getTitle(), is("new blog"));
    }
	
	
	@Test
    public void shouldSaveAndLoadAuthor() {
		Post post = postRepo.save(new Post("new blog", "This is my blog post", "Fry", "08 Mar 2019", "Sports", "Random"));
        Author author = authorRepo.save(new Author("my name", post));
        Long postId = author.getId();
 
        entityManager.persist(author);
        entityManager.flush();
        entityManager.clear();
 
        Optional<Author> authorToFind = authorRepo.findById(postId);
        author = authorToFind.get();
 
        assertThat(author.getAuthor(), is("my name"));
    }

	
}
