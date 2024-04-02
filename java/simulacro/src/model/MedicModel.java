package model;

import database.ConfigDB;
import database.MedicCrud;
import entity.Medic;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MedicModel implements MedicCrud {

    @Override
    public Medic create(Medic medic) {
        Connection objConnection = ConfigDB.openConnection();

        Medic objMedic = (Medic) medic;

        try {
            String sql = "INSERT INTO Medicos(nombre, apellido) VALUES ( ?, ? )";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objMedic.getName());
            objPrepare.setString(2,objMedic.getLastName());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objMedic.setIdMedic(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Medic was added successfully");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error adding new Medic " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objMedic;
    }

    @Override
    public List<Medic> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public void update(Medic medic) {

    }

    @Override
    public void delete(Medic medic) {

    }
}
