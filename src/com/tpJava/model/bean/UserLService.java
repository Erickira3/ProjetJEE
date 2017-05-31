package com.tpJava.model.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public UserL createStudent(UserL obj) throws SQLException {
        new UserLDao().insertUser(obj);
        return obj;
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
