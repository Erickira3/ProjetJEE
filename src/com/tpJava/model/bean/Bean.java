package com.tpJava.model.bean;

/**
 * Created by Erickira on 24/05/2017.
 */
import com.tpJava.controler.LoginDao;

import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class Bean implements Serializable{
    private Bean user;
    private String name;
    private String pass;
    private String email;

    public Bean getUser() {
        return user;
    }

    public void setUser(Bean user) {
        this.user = user;
    }

    private String nom;
    private Integer age;
    private String result;
    private boolean canEdit;
    @ManagedProperty("#{bean}")
    public ArrayList<Bean> listUser= new ArrayList<Bean>();

    public Bean(String login, String nom, int age, String email) {
        this.name = login;
        this.age = age;
        this.email = email;
        this.nom = nom;
        canEdit = false;
    }
    public Bean()
    {

    }

    public void Bean(String name, String pass, String email, String nom, int age)
    {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.nom = nom;
        this.age = age;
        canEdit = false;
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
    }

    public void subselectAdmin() throws SQLException {
        this.name = name;
        this.pass = pass;
        String requete = "SELECT * FROM `userreg` WHERE `name`='" + this.name + "' AND `pass`='"+this.pass+"'";
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

    public ArrayList<Bean> getlistUser() throws SQLException {
        String requete = "SELECT * FROM `userreg` WHERE 1";
        new LoginDao().query(requete);
        ResultSet verif = new LoginDao().query(requete);
        while (verif.next()) {
            String login = verif.getString("name");
            String nom = verif.getString("nom");
            int age = verif.getInt("age");
            String email = verif.getString("email");
            Bean eric = new Bean(login, nom, age, email);
            listUser.add(eric);
        }
        return listUser;
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

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }
    public String addUser() {
        Bean employee = new Bean(name,nom,age,email);
        listUser.add(employee);
        return null;
    }

    public String deleteUser(Bean employee) {
        listUser.remove(employee);
        return null;
    }

    public String editUser(Bean employee) {
        employee.setCanEdit(true);
        return null;
    }

    public String saveUser() {

        //set "canEdit" of all employees to false

        for (Bean employee : listUser) {
            employee.setCanEdit(false);
        }
        return null;
    }
}