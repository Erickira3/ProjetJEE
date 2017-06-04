package src.com.tpJava.model.bean;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.faces.bean.*;
import javax.faces.context.*;
import javax.faces.event.AjaxBehaviorEvent;

import Controller.LoginDao;

@ManagedBean
//(name="RecipeList")
@SessionScoped
public class RecipeList {

	private List<RecipeBean> recipes;
	private List<RecipeCommentsBean> recipeComments;
	private RecipeBean selectedRecipe; 
	
	public RecipeList() {
	}
	
	public String Search() throws SQLException, IOException {
		
		System.out.println("search()");

		//Recuperation des parametres de la recherche
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap(); 
		String time = params.get("time");
		String nbrPerson = params.get("nbrPerson");
		String type = params.get("type");
		String rating = params.get("rating");
		
//		System.out.println("Time : "+time+"\nRating : "+rating+"\nPeople : "+nbrPerson+"\nType : "+type);
		
		//Construction de la requete
		String requete = "SELECT r.id_recipe, r.name, r.time, r.people, r.expertise, r.resume, tr.name as type, tr.id_type as id_type, avg(rc.rating) "
				+ "FROM `recette` r "
				+ "JOIN `type_recette` tr ON tr.id_type = r.id_type "
				+ "LEFT JOIN `recipe_comment` rc ON rc.id_recipe = r.id_recipe "
				+ "WHERE 1 ";
		
		//Ajout des parametres de recherche a la requete
		if(time != null) {
			requete += "AND time = '"+time+"' ";
		}
		if(nbrPerson != null) {
			requete += "AND people = '"+nbrPerson+"' ";
		}
		if(rating != null) {
			requete += "AND expertise = "+rating+" ";
		}
		if(type != null) {
			requete += "AND tr.name = '"+type+"' ";
		}
		
		requete += "GROUP BY r.id_recipe";
		
		//Execution de la requete
//        System.out.println(requete);
//        ResultSet results = new LoginDao().query(requete);
//        
		recipes = new ArrayList<>();
		RecipeBean r;
        
        //Parcours des resultats
//        while (results.next()) {
//            r = new RecipeBean();
//			r.setName(results.getString("name"));
//			r.setTime(results.getInt("time"));
//			r.setRating(results.getInt("expertise"));
//			r.setType(results.getString("type"));
//			r.setNbrPerson(results.getInt("people"));
//			r.setResume(results.getString("resume"));
//			recipes.add(r);
//        }
		
        r = new RecipeBean();
        r.setId(1);
		r.setName("name");
		r.setTime("12");
		r.setRating(4);
		r.setType("Salad");
		r.setNbrPerson(1);
		r.setResume("BlablaBlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla Blabla Blabla BlablaBlabla");

		recipes.add(r);

        r = new RecipeBean();
        r.setId(2);
		r.setName("name2");
		r.setTime("3");
		r.setRating(4);
		r.setType("Salad");
		r.setNbrPerson(1);
		r.setResume("BlablaBlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla Blabla Blabla BlablaBlabla");

		recipes.add(r);

        r = new RecipeBean();
        r.setId(3);
		r.setName("name3");
		r.setTime("2");
		r.setRating(4);
		r.setType("Salad");
		r.setNbrPerson(1);
		r.setResume("BlablaBlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla BlablaBlabla Blabla Blabla BlablaBlabla");

		recipes.add(r);
		
//		FacesContext.getCurrentInstance().getExternalContext().redirect("search.jsf");
        
        return "search.jsf";
        
	}

	public List<RecipeBean> getRecipes() {
		return recipes;
	}
	
	public void setRecipeComments(List<RecipeCommentsBean> recipes) {
		this.recipeComments = recipeComments;
	}
	
	public List<RecipeCommentsBean> getRecipeComments() {
		return recipeComments;
	}
	
	public void setRecipes(List<RecipeCommentsBean> recipeComments) {
		this.recipes = recipes;
	}
	
	public RecipeBean getSelectedRecipe() {
		return selectedRecipe;
	}
	
	public void setSelectedRecipe(RecipeBean selectedRecipe) {
		this.selectedRecipe = selectedRecipe;
	}
	
	//Récupération des commentaires de la recette et affichage de la page
	public String printRecipe() {
				
		String requete = "SELECT u.name, c.date, c.comment, c.rating"
				+ "FROM recipe_comments c"
				+ "JOIN user u ON u.id_user = c.id_user"
				+ "WHERE id_recipe = " + selectedRecipe.getId();
		
		//Execution de la requete
//      System.out.println(requete);
//      ResultSet results = new LoginDao().query(requete);
//      
		recipeComments = new ArrayList<>();
		RecipeCommentsBean rc;
      
      //Parcours des resultats
//      while (results.next()) {
//            rc = new RecipeCommentsBean();
//			rc.setUser(results.getString("name"));
//			rc.setDate(results.getInt("time"));
//			rc.setComment(results.getString("comment"));
//			rc.setRating(results.getInt("rating"));
//			recipeComments.add(rc);
//      }
		
		rc = new RecipeCommentsBean();
		rc.setUser("jon");
		rc.setDate(new Date(0).getTime());
		rc.setComment("Commentaire 1.");
		rc.setRating(3);
		recipeComments.add(rc);
		
		rc = new RecipeCommentsBean();
		rc.setUser("eric");
		rc.setDate(new Date(0).getTime());
		rc.setComment("Commentaire 2.");
		rc.setRating(1);
		recipeComments.add(rc);
				
		return "recette.xhtml";
	}

}
