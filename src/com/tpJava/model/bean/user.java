package com.tpJava.model.bean;

import javax.faces.annotation.ManagedProperty;
import java.util.ArrayList;

/**
 * Created by Erickira on 30/05/2017.
 */
public class user {
    private user user;
    private String name;
    private String pass;
    private String email;

    private Integer age;
    private String result;
    private boolean canEdit;
    private transient boolean editable;



    public user(String login, String nom, int age, String email) {
        this.name = login;
        this.age = age;
        this.email = email;
        this.nom = nom;
        canEdit = false;
    }
    public user()
    {

    }

    public void user(String name, String pass, String email, String nom, int age)
    {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.nom = nom;
        this.age = age;
        canEdit = false;
    }
    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    private String nom;

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

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
