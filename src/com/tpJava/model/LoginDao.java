package com.tpJava.model;

/**
 * Created by Erickira on 23/05/2017.
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.jdbc.*;
public class LoginDao {
    public static boolean validate(String name,String pass){
        boolean status=false;
        try{
            // Step 1: Allocate a database Connection object
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetjee", "root", ""); // <== Check!
            // database-URL(hostname, port, default database), username, password

            // Step 2: Allocate a Statement object within the Connection

            PreparedStatement ps=con.prepareStatement(
                    "select * from userreg where name=? and pass=?");
            ps.setString(1,name);
            ps.setString(2,pass);

            ResultSet rs=ps.executeQuery();
            status=rs.next();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }
}
