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
public class UserLService {
    private static UserLService INSTANCE = new UserLService();

    public static UserLService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UserLService();
        }
        return INSTANCE;
    }

    public void createStudent(UserL obj) throws SQLException {
        System.out.println(obj);

        new UserLDao().insertUser(obj);
//        return obj;
    }

    public void toEditUser(UserL user) {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("currentEditUser", user);
    }

    public void cancelEditUser() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        if (null != sessionMap.get("currentEditUser")) {
            sessionMap.remove("currentEditUser");
        }
    }

    public UserL findStudent(UserL obj) throws SQLException {
        return new UserLDao().selectUser(obj);
    }

    public ArrayList<UserL> findAll() throws SQLException {
        return new UserLDao().getlistUser();
    }

    public void deleteStudent(UserL student) throws SQLException {
        UserLDao studentDAO = new UserLDao();
        new UserLDao().delete(student);
    }

    public void update(UserL student) throws SQLException {
        UserLDao studentDAO = new UserLDao();

    }
}
