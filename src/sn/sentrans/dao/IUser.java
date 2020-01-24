package sn.sentrans.dao;

import sn.sentrans.entities.User;

import java.util.List;

public interface IUser {
    public int add(User user);
    public int update(User user);
    public int delete(int id);
    public List<User> getAll();
    public User get(int id);
    public User getLogin( String email, String password);
}
