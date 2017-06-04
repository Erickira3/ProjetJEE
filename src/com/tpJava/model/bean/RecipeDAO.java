package com.tpJava.model.bean;

import com.tpJava.controler.LoginDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Erickira on 31/05/2017.
 */
@ManagedBean
@SessionScoped
public class RecipeDAO {

    private Connection connection;
    private Statement statement;
    private String result;
    private ArrayList<RecipeBean> listUser = new ArrayList<RecipeBean>();


    public RecipeDAO() {
        super();
    }

    public void insertUser(RecipeBean obj) throws SQLException {
        result = "Submitted values: " + obj.getName() + ", " + obj.getRating() + ", " + obj.getNbrPerson() + ", " + obj.getResume() ;

        String requete = "INSERT INTO `recipe`(`name`, `rating`, `people`, `resume`) VALUES ('" + obj.getName() +"','"+obj.getRating()+"','"+obj.getNbrPerson()+"','"+obj.getResume()+"') ON DUPLICATE KEY UPDATE `rating`='"+obj.getRating()+"',`people`='"+obj.getNbrPerson()+"',`resume`='"+obj.getResume()+"';";
        System.out.println(requete);
        new LoginDao().insert(requete);
    }

//    public void subAdmin(RecipeBean obj) throws SQLException {
//        result = "Submitted values: " + obj.getName() + ", " + obj.getPass() + ", " + obj.getEmail() + ", " + obj.getNom() + ", " + obj.getAge() ;
//        System.out.println(result);
//        String requete = "INSERT INTO `recipe`(`name`, `pass`, `nom`, `email`, `age`) VALUES ('" + user.name +"','"+user.pass+"','"+user.nom+"','"+user.email+"','"+user.age+"')";
//        System.out.println(requete);
//        new LoginDao().insert(requete);
//    }

    public RecipeBean selectUser(RecipeBean obj) throws SQLException {
        result = "Submitted values: " + obj.getName() + ", " + obj.getType();
        System.out.println(result);
        String requete = "SELECT * FROM `recipe` WHERE `name`='" + obj.getName() + "' AND `type`='"+obj.getType()+"'";
        System.out.println(requete);
        return null;
    }

    public ArrayList<RecipeBean> getlistUser() throws SQLException {
        String requete = "SELECT * FROM `recipe` WHERE 1";
        new LoginDao().query(requete);
        ResultSet verif = new LoginDao().query(requete);
        while (verif.next()) {
            String name = verif.getString("name");
            String type = verif.getString("id_type");
            String time = verif.getString("time");
            int rating = verif.getInt("rating");
            int people = verif.getInt("people");
            String resume = verif.getString("resume");
            RecipeBean eric = new RecipeBean(name, time, rating, people, type, resume);
            listUser.add(eric);
        }
        return listUser;
    }

    public void delete(RecipeBean obj) throws SQLException {
        String requete = "DELETE FROM `recipe` WHERE `name`='"+obj.getName()+"';";
        new LoginDao().insert(requete);
    }
}
