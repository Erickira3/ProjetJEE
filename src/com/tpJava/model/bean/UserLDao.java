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
public class UserLDao {

    final String INSERT_CLAUSE = "INSERT INTO student (firstname,lastname,sex,major,year,birthdate) VALUES(?, ?, ?, ?, ?, ?)";
    final String SELECT_TRANSACTION = "SELECT * FROM student";
    final String DELETE = "DELETE FROM student";
    final String UPDATE = "UPDATE student";

    private Connection connection;
    private Statement statement;
    private String result;
    private ArrayList<UserL> listUser = new ArrayList<UserL>();


    public UserLDao() {
        super();
    }

    public void insertUser(UserL obj) throws SQLException {
        result = "Submitted values: " + obj.getName() + ", " + obj.getPass() + ", " + obj.getEmail() + ", " + obj.getNom() + ", " + obj.getAge() ;
        System.out.println(result);
        String requete = "INSERT INTO `userreg`(`name`, `pass`, `nom`, `email`, `age`) VALUES ('" + obj.getName() +"','"+obj.getPass()+"','"+obj.getNom()+"','"+obj.getEmail()+"','"+obj.getAge()+"')";
        System.out.println(requete);
        new LoginDao().insert(requete);
    }

//    public void subAdmin(UserL obj) throws SQLException {
//        result = "Submitted values: " + obj.getName() + ", " + obj.getPass() + ", " + obj.getEmail() + ", " + obj.getNom() + ", " + obj.getAge() ;
//        System.out.println(result);
//        String requete = "INSERT INTO `userreg`(`name`, `pass`, `nom`, `email`, `age`) VALUES ('" + user.name +"','"+user.pass+"','"+user.nom+"','"+user.email+"','"+user.age+"')";
//        System.out.println(requete);
//        new LoginDao().insert(requete);
//    }

    public UserL selectUser(UserL obj) throws SQLException {
        result = "Submitted values: " + obj.getName() + ", " + obj.getPass();
        System.out.println(result);
        String requete = "SELECT * FROM `userreg` WHERE `name`='" + obj.getName() + "' AND `pass`='"+obj.getPass()+"'";
        System.out.println(requete);
        return null;
    }

    public void selectAdmin(UserL obj) throws SQLException {
        String requete = "SELECT * FROM `userreg` WHERE `name`='" + obj.getName() + "' AND `pass`='"+obj.getPass()+"'";
        System.out.println(requete);
        new LoginDao().query(requete);
        ResultSet verif = new LoginDao().query(requete);
        while (verif.next()) {
            String login = verif.getString("name");
            int admin = verif.getInt("admin");
            System.out.println(login + "\t" + admin);
            if(admin==0)
            {
                System.out.println("Utilisateur non accepté");
            }
            else
            {
                System.out.println("Bievenue admin");
            }
        }
    }

    public ArrayList<UserL> getlistUser() throws SQLException {
        String requete = "SELECT * FROM `userreg` WHERE 1";
        new LoginDao().query(requete);
        ResultSet verif = new LoginDao().query(requete);
        while (verif.next()) {
            String login = verif.getString("name");
            String nom = verif.getString("nom");
            int age = verif.getInt("age");
            String email = verif.getString("email");
            UserL eric = new UserL(login, nom, age, email);
            System.out.println(eric);
            listUser.add(eric);
        }
        return listUser;
    }

    public void update(UserL obj) throws SQLException {
        String requete = "UPDATE `userreg` SET `nom`='"+obj.getNom()+"',`email`='"+obj.getEmail()+"',`age`='"+obj.getAge()+"' WHERE `name`='"+obj.getName()+"';";
        new LoginDao().insert(requete);
    }

    public void delete(UserL obj) throws SQLException {
        String requete = "DELETE FROM `userreg` WHERE `name`='"+obj.getName()+"';";
        new LoginDao().insert(requete);
    }
}
