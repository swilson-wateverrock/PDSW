package edu.eci.pdsw.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.entities.Comment;

public interface CommentsMapper {
	
	List<Comment> searchCommentsByBlogTitle(@Param("tittle") String tittle);
	
	List<Comment> searchOffensiveLanguageComments();


}
