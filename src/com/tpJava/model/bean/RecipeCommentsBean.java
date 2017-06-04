package src.com.tpJava.model.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.crypto.Data;

import Controller.LoginDao;

import java.sql.*;

import java.util.Date;

@ManagedBean(name="RecipeCommentsBean")
@SessionScoped
public class RecipeCommentsBean implements Serializable{
	private Integer id;
	private Integer idUser;
	private String user;
	private Integer idRecipe;
	private long date;
	private String comment;
	private Integer rating;
	
	public RecipeCommentsBean(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
	}

	public void addComment() throws SQLException {
		
		idRecipe = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id_recipe"));
//		idUser = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id_user"));
		
		date = new Date().getTime();
		
		//Construction de la requete
//		String requete = "INSERT INTO recipe_comments (id_recipe, id_user, date, comment, rating) "
//				+ "VALUES ("+idRecipe+", "+idUser+", '"+date+"', '"+comment+"', "+rating+")";
//		
//		new LoginDao().insert(requete);
	}

}