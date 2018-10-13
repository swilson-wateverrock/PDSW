package edu.eci.pdsw.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.google.inject.Inject;

import edu.eci.pdsw.entities.Comment;
import edu.eci.pdsw.services.BlogServices;
import edu.eci.pdsw.services.ServicesException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "commentBean")
@RequestScoped

public class CommentBean extends BasePageBean {
	
	@ManagedProperty(value = "#{param.title}")
	private String title;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private BlogServices blogServices;
	
	public List<Comment> getCommentsFromTitle() throws Exception {
		try {
			return blogServices.searchCommentsByBlogTitle(title);
		} catch (ServicesException ex) {
			throw ex;
		}
	}

	public List<Comment> getCommentsOffensive() throws Exception {
		try {
			return blogServices.searchOffensiveLanguageComments();
		} catch (ServicesException ex) {
			throw ex;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String blog) {
		this.title = title;
	}

	
}
