package sn.sentrans.dao;

import sn.sentrans.entities.Bus;

import java.util.List;

public interface IBus {
    public int add(Bus bus);
    public int update(Bus bus);
    public int delete(int id);
    public List<Bus> getAll();
    public Bus get(String matricule);
}
