package edu.cmu.mis.iccfb.service;

import java.util.List;

import edu.cmu.mis.iccfb.model.Quote;

public interface QuoteService {
	public Quote randomQuote();
	
	public List<Quote> findByAuthorId(Long authorId);
	
	public Quote save(Quote q);
}
