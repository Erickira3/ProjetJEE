package com.tpJava.model.bean;

/**
 * Created by Erickira on 24/05/2017.
 */
import com.tpJava.controler.LoginDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ManagedBean
@RequestScoped
public class Bean {
    private Bean user;
    private String name;
    private String pass;
    private String email;
    private String nom;
    private Integer age;
    private String result;

    public void Bean(String name, String pass, String email, String nom, int age)
    {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.nom = nom;
        this.age = age;

    }
    public void subinsert() throws SQLException {
        result = "Submitted values: " + name + ", " + pass + ", " + email + ", " + nom + ", " + age ;
        System.out.println(result);
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.nom = nom;
        this.age = age;
        String requete = "INSERT INTO `userreg`(`name`, `pass`, `nom`, `email`, `age`) VALUES ('" + this.name +"','"+this.pass+"','"+this.nom+"','"+this.email+"','"+this.age+"')";
        System.out.println(requete);
        new LoginDao().insert(requete);
    }

    public void subselect() throws SQLException {
        result = "Submitted values: " + name + ", " + pass;
        System.out.println(result);
        this.name = name;
        this.pass = pass;
        String requete = "SELECT * FROM `userreg` WHERE `name`='" + this.name + "' AND `pass`='"+this.pass+"'";
        System.out.println(requete);
        new LoginDao().query(requete);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }
}