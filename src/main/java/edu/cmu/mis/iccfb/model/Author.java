package edu.cmu.mis.iccfb.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@jsonid")
public class Author {

    private Long id;

    private String name;
    
    private List<Quote> quotes;
    
	protected Author() {}

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Author[id=%d, name='%s']", id, this.name);
    }
    
    public Long getId () {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
}
