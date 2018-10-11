package edu.eci.pdsw.persistence;

import java.util.List;

import edu.eci.pdsw.entities.Blog;
import edu.eci.pdsw.entities.Comment;

public interface CommentDAO {

    public List<Comment> loadByBlogTitle(String tittle) throws PersistenceException;
    
    public List<Comment> searchOffensiveLanguageComments() throws PersistenceException;

    
    


}
