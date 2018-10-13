package edu.eci.pdsw.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.entities.Comment;

public interface CommentsMapper {
	
	/*
	 * cambié ambas consultas, las anteriores por alguna razón no servian
	 * !usar más seguidos los join!
	 */
	
	/*
	 * Historia de ususario 1
	 */
	List<Comment> searchCommentsByBlogTitle(@Param("title") String title);
	
	
	/*
	 * Historia de ususario 2
	 */
	List<Comment> searchOffensiveLanguageComments();
	
}
