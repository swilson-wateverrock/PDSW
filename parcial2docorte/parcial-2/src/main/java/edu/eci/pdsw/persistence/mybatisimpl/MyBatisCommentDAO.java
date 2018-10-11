package edu.eci.pdsw.persistence.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.persistence.CommentDAO;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.BlogMapper;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.CommentsMapper;

public class MyBatisCommentDAO implements CommentDAO{
	
	@Inject
	CommentsMapper commentsMapper;

	@Override
	public List<Comment> loadByBlogTitle(String tittle) throws PersistenceException { 
		return commentsMapper.searchCommentsByBlogTitle(tittle);
	}

	@Override
	public List<Comment> searchOffensiveLanguageComments() throws PersistenceException {
		return commentsMapper.searchOffensiveLanguageComments();
	}


}
