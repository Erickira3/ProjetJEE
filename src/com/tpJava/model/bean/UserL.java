package com.tpJava.model.bean;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Erickira on 31/05/2017.
 */

@ManagedBean
@SessionScoped
public class UserL {
    private UserL user;
    private String name;
    private String pass;
    private String email;
    private String nom;
    private Integer age;
    private String result;
    private boolean canEdit;
    public ArrayList<UserL> listUser= new ArrayList<UserL>();

    public UserL(String login, String nom, int age, String email) {
        this.name = login;
        this.age = age;
        this.email = email;
        this.nom = nom;
        canEdit = false;
    }
    public UserL()
    {

    }

    public void UserL(String name, String pass, String email, String nom, int age)
    {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.nom = nom;
        this.age = age;
        canEdit = false;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<UserL> getListUser() throws SQLException {
        ArrayList<UserL> acc = new UserLService().findAll();
        setListUser(acc);
        return acc;
    }


    public void setListUser(ArrayList<UserL> listUser) {
        this.listUser = listUser;
    }

    public String editAction(UserL order) {
        this.age=order.age;
        this.name=order.name;
        this.nom=order.nom;
        this.email=order.email;
        this.pass=order.pass;
        System.out.println(this.nom);
        return null;
    }

    public UserL getUser() {
        return user;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void submit() throws SQLException {
        UserL acc = new UserL();
        acc.name=name;
        acc.pass=pass;
        acc.age=age;
        acc.email=email;
        acc.nom=nom;
        new UserLService().createStudent(acc);
    }

    public void setUser(UserL user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "UserL{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }
}
