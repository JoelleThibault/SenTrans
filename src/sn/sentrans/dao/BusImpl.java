package sn.sentrans.dao;

import sn.sentrans.entities.Bus;
import sn.sentrans.entities.Localite;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusImpl implements IBus {

    private DB db = new DB();

    @Override
    public int add(Bus bus) {
        String sql = "INSERT INTO bus VALUES(NULL, ?, ?, ?,)";
        int ok = 0;
        try{
            db.init(sql);
            db.getPstm().setInt(1, bus.getNbplace());
            db.getPstm().setString(2, bus.getMatricule());
            db.getPstm().setInt(3, bus.getLocalite().getIdL());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Bus bus) {
        String sql = "UPDATE bus SET nbplace = ?, matricule = ?, localite = ?, WHERE id = ?";
        int ok = 0;
        try{
            db.init(sql);
            db.getPstm().setInt(1, bus.getNbplace());
            db.getPstm().setString(2, bus.getMatricule());
            db.getPstm().setInt(3, bus.getLocalite().getIdL());
            db.getPstm().setInt(4, bus.getId());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM bus WHERE id = ?";
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
    public List<Bus> getAll() {
        String sql = "SELECT * FROM bus";

        List<Bus> busList = new ArrayList<>();
        try{
            db.init(sql);
            ResultSet rs = db.executeSelect();
            while(rs.next()){
                Bus bus = new Bus();
                bus.setId(rs.getInt(1));
                bus.setNbplace(rs.getInt(2));
                bus.setMatricule(rs.getString(3));
                //Gestion de la localite
                Localite localite = new Localite();
                localite.setIdL(rs.getInt(4));
                bus.setLocalite(localite);
                //Ajout dans la liste des bus
                busList.add(bus);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return busList;
    }

    @Override
    public Bus get(String matricule) {
        String sql = "SELECT * FROM bus WHERE matricule = ?";

        Bus bus = null;
        try{
            db.init(sql);
            db.getPstm().setString(1,matricule);
            ResultSet rs = db.executeSelect();
            if(rs.next()){
                bus = new Bus();
                bus.setId(rs.getInt(1));
                bus.setNbplace(rs.getInt(2));
                bus.setMatricule(rs.getString(3));
                //Gestion de la localite
                Localite localite = new Localite();
                localite.setIdL(rs.getInt(4));
                bus.setLocalite(localite);

            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return bus;
    }
}
