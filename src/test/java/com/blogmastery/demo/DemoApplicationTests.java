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
import com.blogmastery.demo.models.BlogTag;
import com.blogmastery.demo.models.Genre;
import com.blogmastery.demo.models.Post;
import com.blogmastery.demo.repositories.AuthorRepository;
import com.blogmastery.demo.repositories.BlogTagRepository;
import com.blogmastery.demo.repositories.GenreRepository;
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
	
	@Resource 
	private GenreRepository genreRepo;
	
	@Resource
	private BlogTagRepository tagRepo;
	
	@Test
    public void shouldSaveAndLoadPost() {
		Genre testGenre = genreRepo.save(new Genre("sports"));
        BlogTag testTag = tagRepo.save(new BlogTag("test"));
        Author testAuthor = authorRepo.save(new Author("Fry"));
		Post post = postRepo.save(new Post("new blog", "This is my blog post", testAuthor, testGenre, testTag));
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
		Author testAuthor = authorRepo.save(new Author("Fry"));
		Genre testGenre = genreRepo.save(new Genre("sports"));
		BlogTag testTag = tagRepo.save(new BlogTag("test"));
		Post post = postRepo.save(new Post("new blog", "This is my blog post", testAuthor, testGenre, testTag));
        Author author = authorRepo.save(new Author("my name", post));
        Long postId = author.getId();
 
        entityManager.persist(author);
        entityManager.flush();
        entityManager.clear();
 
        Optional<Author> authorToFind = authorRepo.findById(postId);
        author = authorToFind.get();
 
        assertThat(author.getAuthor(), is("my name"));
    }
	@Test
    public void shouldSaveAndLoadTag() {
		//Post post = postRepo.save(new Post("new blog", "This is my blog post", "Fry", "08 Mar 2019", "Sports", "Random"));
        BlogTag tag = tagRepo.save(new BlogTag("tag"));
        Long tagId = tag.getId();
 
        entityManager.persist(tag);
        entityManager.flush();
        entityManager.clear();
 
        Optional<BlogTag> tagToFind = tagRepo.findById(tagId);
        tag = tagToFind.get();
 
        assertThat(tag.getTagName(), is("tag"));
    }
	@Test 
	public void shouldSaveAndLoadGenre() {
		Genre genre = genreRepo.save(new Genre("romance"));
		Long genreID = genre.getId();
		
		entityManager.persist(genre);
        entityManager.flush();
        entityManager.clear();
		
        Optional<Genre> genreToFind = genreRepo.findById(genreID);
        genre = genreToFind.get();
        
        assertThat(genre.getGenre(), is ("romance"));
		
	}
	
}
