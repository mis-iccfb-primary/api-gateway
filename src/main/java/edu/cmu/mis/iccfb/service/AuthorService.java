package edu.cmu.mis.iccfb.service;


import edu.cmu.mis.iccfb.model.Author;

public interface AuthorService {

    Author findByName(String name);
    Author save(Author a);
    Author findOne(Long id);

}
