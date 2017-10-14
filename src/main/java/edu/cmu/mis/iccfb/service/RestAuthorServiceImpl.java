package edu.cmu.mis.iccfb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.cmu.mis.iccfb.model.Author;

@Service
public class RestAuthorServiceImpl implements AuthorService {

	@Value("${service.author.host}")
	private String authorServiceHost;
	
	@Override
	public Author findByName(String name) {
		RestTemplate rest = new RestTemplate();
		Author result = rest.getForObject(this.getFullURL("/api/author/byname?name={authorName}"), Author.class, name);
		return result;
	}

	@Override
	public Author save(Author a) {
		RestTemplate rest = new RestTemplate();
		Author result = rest.postForObject(this.getFullURL("/api/author"), a, Author.class);
		return result;
	}

	@Override
	public Author findOne(Long id) {
		RestTemplate rest = new RestTemplate();
		Author result = rest.getForObject(this.getFullURL("/api/author/{id}"), Author.class, id);
		return result;
	}
	
	private String getFullURL(String path) {
		return "http://"+authorServiceHost+path;
	}


}
