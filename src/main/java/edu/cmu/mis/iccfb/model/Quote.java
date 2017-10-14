package edu.cmu.mis.iccfb.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@jsonid")
public class Quote {

    private Long id;


    private String text;

    private String source;
    
    
    private Long authorId;
    private Author author;
    

    public Quote() {}


    @Override
    public String toString() {
        return String.format("Quote[id=%d, text='%s', by='%s']", this.id, this.text, this.authorId);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
		this.setAuthorId(author.getId());
	}
    
    
}
