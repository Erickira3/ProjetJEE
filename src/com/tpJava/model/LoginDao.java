package com.tpJava.model;

/**
 * Created by Erickira on 23/05/2017.
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mysql.jdbc.*;
public class LoginDao {
    public Connection conn;
    private Statement statement;
    public static LoginDao db;
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
    /**
     * @desc A singleton database access class for MySQL
     * @author Ramindu
     */
        /**
         *
         * @return MysqlConnect Database connection object
         */
        public static synchronized LoginDao getDbCon() {
            if ( db == null ) {
                db = new LoginDao();
            }
            return db;

        }
        /**
         *
         * @param query String The query to be executed
         * @return a ResultSet object containing the results or null if not available
         * @throws SQLException
         */
        public ResultSet query(String query) throws SQLException{
            statement = db.conn.createStatement();
            ResultSet res = statement.executeQuery(query);
            return res;
        }
        /**
         * @desc Method to insert data to a table
         * @param insertQuery String The Insert query
         * @return boolean
         * @throws SQLException
         */
        public int insert(String insertQuery) throws SQLException {
            statement = db.conn.createStatement();
            int result = statement.executeUpdate(insertQuery);
            return result;

        }

    private LoginDao() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "projetjee";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
}

