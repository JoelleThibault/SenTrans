package sn.sentrans.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;
    private int ok;

    private void getConnection() {
        String mysqlurl = "jdbc:mysql://localhost:3306/sentrans";
        String mysqluser = "root";
        String mysqlpassword = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(mysqlurl, mysqluser, mysqlpassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void init(String sql) {
        try {
            getConnection();
            pstm = con.prepareStatement(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet executeSelect() {
        try {
            rs = pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public int executeMaj() {
        try {
            ok = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ok;
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    public void closeConnection() {
        try {
            if (con != null)
                con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}