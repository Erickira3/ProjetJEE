package com.tpJava.model.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Time;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sun.org.apache.regexp.internal.RE;
import com.tpJava.controler.LoginDao;
import java.sql.*;
import java.util.ArrayList;

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
	private RecipeBean recipe;
	public ArrayList<RecipeBean> listRecipe= new ArrayList<RecipeBean>();


	public RecipeBean(){
	}

	public RecipeBean(String name, String time, Integer rating, Integer nbrPerson, String type, String resume) {
		this.name = name;
		this.time = time;
		this.rating = rating;
		this.nbrPerson = nbrPerson;
		this.type = type;
		this.resume = resume;
	}

	public ArrayList<RecipeBean> getListRecipe() throws SQLException {
		ArrayList<RecipeBean> acc = new RecipeService().findAll();
		setListRecipe(acc);
		return acc;
	}

	public Integer getId() {
		return id;
	}

	public RecipeBean getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeBean recipe) {
		this.recipe = recipe;
	}

	public void setListRecipe(ArrayList<RecipeBean> listRecipe) {
		this.listRecipe = listRecipe;
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