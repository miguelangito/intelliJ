package model;

import database.ConfigDB;
import database.SpecialityCrud;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SpecialityModel implements SpecialityCrud {

    @Override
    public Speciality create(Speciality speciality) {
        Connection objConnection = ConfigDB.openConnection();

        Speciality objSpeciality = (Speciality) speciality;

        try {
            String sql = "INSERT INTO Especialidades(nombre, descripcion) VALUES ( ?, ? )";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objSpeciality.getName());
            objPrepare.setString(2, objSpeciality.getDescription());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getResultSet();
            while (objResult.next()){
                objSpeciality.setIdEspeciality(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null,"Speciality adding was successful");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error adding new Speciality" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objSpeciality;
    }

    @Override
    public List<Speciality> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public void update(Speciality speciality) {

    }

    @Override
    public void delete(Speciality speciality) {

    }
}
