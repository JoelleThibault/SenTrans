package sn.sentrans.dao;

import sn.sentrans.entities.User;

import java.sql.ResultSet;
import java.util.List;

public class UserImpl implements IUser {
    private DB db = new DB();
    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getLogin(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try{
            db.init(sql);
            db.getPstm().setString(1,email);
            db.getPstm().setString(2,password);

            ResultSet rs = db.executeSelect();
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));



            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
}
