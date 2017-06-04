package com.tpJava.model.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Erickira on 31/05/2017.
 */
@ManagedBean
@SessionScoped
public class RecipeService {
    private static RecipeService INSTANCE = new RecipeService();

    public static RecipeService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new RecipeService();
        }
        return INSTANCE;
    }

    public void createRecipe(RecipeBean obj) throws SQLException {
        System.out.println(obj);

        new RecipeDAO().insertUser(obj);
//        return obj;
    }

    public void toEditUser(RecipeBean user) {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("currentEditUser", user);
    }

    public void cancelEditUser() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        if (null != sessionMap.get("currentEditUser")) {
            sessionMap.remove("currentEditUser");
        }
    }

    public RecipeBean findRecipe(RecipeBean obj) throws SQLException {
        return new RecipeDAO().selectUser(obj);
    }

    public ArrayList<RecipeBean> findAll() throws SQLException {
        return new RecipeDAO().getlistUser();
    }

    public void deleteRecipe(RecipeBean student) throws SQLException {
        RecipeDAO studentDAO = new RecipeDAO();
        new RecipeDAO().delete(student);
    }

    public void update(RecipeBean student) throws SQLException {
        RecipeDAO studentDAO = new RecipeDAO();

    }
}
