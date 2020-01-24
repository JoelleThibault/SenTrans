package sn.sentrans.dao;

import sn.sentrans.entities.Localite;
import sn.sentrans.entities.TypeLocalite;
import sn.sentrans.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocaliteImpl implements ILocalite {
    private DB db = new DB();

    @Override
    public int add(Localite localite) {
        String sql = "INSERT INTO localite VALUES(NULL, ?, ?, ?, ?, ?,)";
        int ok = 0;
        try{
            db.init(sql);
            db.getPstm().setDouble(1, localite.getLatitude());
            db.getPstm().setDouble(2, localite.getLongitude());
            db.getPstm().setString(3, localite.getNom());
            db.getPstm().setInt(4, localite.getTypeLocalite().getIdT());
            db.getPstm().setInt(5, localite.getUser().getId());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Localite localite) {
        String sql = "UPDATE  localite SET nom = ?, latitude = ?, longitude = ?, typeLocalite = ?, user = ? ,WHERE id = ?";
        int ok = 0;
        try{
            db.init(sql);
            db.getPstm().setDouble(1, localite.getLatitude());
            db.getPstm().setDouble(2, localite.getLongitude());
            db.getPstm().setString(3, localite.getNom());
            db.getPstm().setInt(4, localite.getTypeLocalite().getIdT());
            db.getPstm().setInt(5, localite.getUser().getId());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM localite WHERE idL = ?";
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
    public List<Localite> getAll() {
        String sql = "SELECT * FROM localite";

        List<Localite> localiteList = new ArrayList<>();
        try{
            db.init(sql);
            ResultSet rs = db.executeSelect();
            while(rs.next()){
                Localite localite = new Localite();
                localite.setIdL(rs.getInt(1));
                localite.setLatitude(rs.getDouble(2));
                localite.setLongitude(rs.getDouble(3));
                localite.setNom(rs.getString(4));

                //Gestion de la type localite
                TypeLocalite typeLocalite = new TypeLocalite();
                typeLocalite.setIdT(rs.getInt(5));
                //Gestion du user
                User user = new User();
                user.setId(rs.getInt(6));


                localite.setTypeLocalite(typeLocalite);

                //Ajout dans la liste des bus
                localiteList.add(localite);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return localiteList;
    }

    @Override
    public Localite get(int id) {
        String sql = "SELECT * FROM localite WHERE id = ?";
        Localite localite = new Localite();

        try{
            db.init(sql);
            db.getPstm().setInt(1,id);
            ResultSet rs = db.executeSelect();

            if(rs.next()){
                localite = new Localite();
                localite.setIdL(rs.getInt(1));
                localite.setLatitude(rs.getDouble(2));
                localite.setLongitude(rs.getDouble(3));
                localite.setNom(rs.getString(4));

                //Gestion de la type localite
                TypeLocalite typelocalite = new TypeLocalite();
                typelocalite.setIdT(rs.getInt(5));
                //Gestion du user
                User user = new User();
                user.setId(rs.getInt(6));


                localite.setTypeLocalite(typelocalite);

            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return localite;
    }

}
