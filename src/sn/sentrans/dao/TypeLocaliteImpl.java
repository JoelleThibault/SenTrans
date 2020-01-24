package sn.sentrans.dao;

import sn.sentrans.entities.TypeLocalite;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeLocaliteImpl implements ITypeLocalite {

    private DB db = new DB();
    @Override
    public int add(TypeLocalite typeLocalite) {
        String sql = "INSERT INTO localite VALUES(NULL, ?,)";
        int ok = 0;
        try{
            db.init(sql);
            db.getPstm().setString(1, typeLocalite.getNom());
            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(TypeLocalite typeLocalite) {
        String sql = "UPDATE  typelocalite SET nom = ?,WHERE idLT= ?";
        int ok = 0;
        try{
            db.init(sql);
            db.getPstm().setString(1, typeLocalite.getNom());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM typelocalite WHERE idT = ?";
        int ok = 0;
        try{
            db.init(sql);
            db.getPstm().setInt(1, id);

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<TypeLocalite> getAll() {
        String sql = "SELECT * FROM typelocalite";

        List<TypeLocalite> typelocaliteList = new ArrayList<>();
        try{
            db.init(sql);
            ResultSet rs = db.executeSelect();
            while(rs.next()){
                TypeLocalite typelocalite = new TypeLocalite();
                typelocalite.setIdT(rs.getInt(1));
                typelocalite.setNom(rs.getString(2));

                //Ajout dans la liste des bus
                typelocaliteList.add(typelocalite);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return typelocaliteList;
    }

    @Override
    public TypeLocalite get(int id) {
        String sql = "SELECT * FROM typelocalite WHERE idT = ?";
        TypeLocalite typeLocalite = new TypeLocalite();

        try{
            db.init(sql);
            db.getPstm().setInt(1,id);
            ResultSet rs = db.executeSelect();

            if(rs.next()){
                typeLocalite = new TypeLocalite();
                typeLocalite.setIdT(rs.getInt(1));
                typeLocalite.setNom(rs.getString(2));



            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return typeLocalite;
    }
}
