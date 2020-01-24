package sn.sentrans.dao;

import sn.sentrans.entities.TypeLocalite;

import java.util.List;

public interface ITypeLocalite {
    public int add(TypeLocalite typeLocalite);
    public int update(TypeLocalite typeLocalite);
    public int delete(int id);
    public List<TypeLocalite> getAll();
    public TypeLocalite get(int id);
}
