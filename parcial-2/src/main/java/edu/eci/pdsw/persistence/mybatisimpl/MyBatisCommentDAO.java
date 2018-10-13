package edu.eci.pdsw.persistence.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.persistence.CommentDAO;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.persistence.mybatisimpl.mappers.CommentsMapper;

public class MyBatisCommentDAO implements CommentDAO {

	@Inject
	CommentsMapper commentsMapper;

	@Override
	public List<Comment> searchCommentsByBlogTitle(String title) throws PersistenceException {
		try {
			return commentsMapper.searchCommentsByBlogTitle(title);
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenceException("blog tittle not found :v");
		}
	}

	@Override
	public List<Comment> searchOffensiveLanguageComments() throws PersistenceException {
		try {
			return commentsMapper.searchOffensiveLanguageComments();
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenceException("something is not right :v");
		}
	}

}
