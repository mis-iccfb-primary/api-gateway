package edu.cmu.mis.iccfb.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.cmu.mis.iccfb.model.Quote;

@Service
public class RestQuoteServiceImpl implements QuoteService {

	@Value("${service.quote.host}")
	private String quoteServiceHost;
	
	@Override
	public Quote randomQuote() {
		RestTemplate rest = new RestTemplate();
		Quote result = rest.getForObject(this.getFullURL("/api/quote/random"), Quote.class);
		return result;
	}

	@Override
	public List<Quote> findByAuthorId(Long authorId) {
		RestTemplate rest = new RestTemplate();
		
		System.out.println(">>>>"+authorId);
		Quote[] result = rest.getForObject(this.getFullURL("/api/quote/author/{authorId}"), Quote[].class, authorId);
		
		return Arrays.asList(result);
	}

	@Override
	public Quote save(Quote q) {
		RestTemplate rest = new RestTemplate();
		Quote result = rest.postForObject(this.getFullURL("/api/quote"), q, Quote.class);
		return result;
	}
	
	private String getFullURL(String path) {
		return "http://"+quoteServiceHost+path;
	}

}
