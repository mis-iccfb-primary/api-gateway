package edu.cmu.mis.iccfb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.AuthorService;
import edu.cmu.mis.iccfb.service.QuoteService;

@RestController
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    @Autowired
    private QuoteService quoteService;
    
    @RequestMapping("/api/author/{id}")
    public Author getAuthor(@PathVariable(value="id") Long id) {
    	
    	Author a = this.authorService.findOne(id);
    	List<Quote> quotes = this.quoteService.findByAuthorId(id);
    	a.setQuotes(quotes);
        return a;
    }

}
