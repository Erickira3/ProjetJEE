package src.com.tpJava.model.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Time;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Controller.LoginDao;

import java.sql.*;

@ManagedBean(name="RecipeBean")
@SessionScoped
public class RecipeBean implements Serializable{
	private Integer id;
	private String name;
	private String time;
	private Integer rating;
	private Integer nbrPerson;
	private String type;
	private String resume;
	
	public RecipeBean(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getNbrPerson() {
		return nbrPerson;
	}

	public void setNbrPerson(Integer nbrPerson) {
		this.nbrPerson = nbrPerson;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	

}