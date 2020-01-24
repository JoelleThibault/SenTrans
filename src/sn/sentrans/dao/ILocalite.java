package sn.sentrans.dao;

import sn.sentrans.entities.Localite;

import java.util.List;

public interface ILocalite {
    public int add(Localite localite);
    public int update(Localite localite);
    public int delete(int id);
    public List<Localite> getAll();
    public Localite get(int id);
}
