package edu.cmu.mis.iccfb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.AuthorService;
import edu.cmu.mis.iccfb.service.QuoteService;

@RestController
public class QuoteController {
    
    @Autowired
    private QuoteService quoteService;
    
    @Autowired
    private AuthorService authorService;
    
    @RequestMapping("/api/quote/random")
    public Quote random() {
    	Quote q = quoteService.randomQuote();
    	
    	Author a = this.authorService.findOne(q.getAuthorId());
    	
    	q.setAuthor(a);
    	
        return q;
    }
    
    @RequestMapping(value = "/api/quote", method = RequestMethod.POST)
    public void saveQuote(@RequestBody Quote quote) {
        System.out.println(quote);
        
        Author a = authorService.findByName(quote.getAuthor().getName());
        
        if (a == null) {
            a = authorService.save(quote.getAuthor());
        }

        quote.setAuthorId(a.getId());

        quoteService.save(quote);
    }

}
