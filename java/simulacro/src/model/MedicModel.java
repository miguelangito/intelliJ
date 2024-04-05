package model;

import database.CRUD;
import database.ConfigDB;
import entity.Medic;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicModel implements CRUD {

    @Override
    public Medic create(Object medic) {
        Connection objConnection = ConfigDB.openConnection();

        Medic objMedic = (Medic) medic;

        try {
            String sql = "INSERT INTO Medicos(nombre, apellido, id_especialidad) VALUES ( ?, ?, ? )";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objMedic.getName());
            objPrepare.setString(2, objMedic.getLastName());
            objPrepare.setInt(3, objMedic.getIdEspeciality());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objMedic.setIdMedic(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Medic was added successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding new Medic " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objMedic;
    }

    @Override
    public List<Object> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public boolean update(Object medic) {

        Connection objConnection = ConfigDB.openConnection();
        Medic objMedic = (Medic) medic;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE Medicos SET nombre = ?, apellido = ?, id_especialidad = ? WHERE id_medico = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objMedic.getName());
            objPrepare.setString(2, objMedic.getLastName());
            objPrepare.setInt(3, objMedic.getIdEspeciality());
            objPrepare.setInt(4, objMedic.getIdEspeciality());

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "The update was successful");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public Object findById(int id) {
        Connection objConection = ConfigDB.openConnection();

        Medic objMedic = null;
        try {
            String sql = "SELECT * FROM  Medicos WHERE id_medico = ?;";

            PreparedStatement objPrepare = objConection.prepareStatement(sql);

            objPrepare.setInt(1, id);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                objMedic = new Medic();

                objMedic.setIdMedic(objResult.getInt("id_medico"));
                objMedic.setName(objResult.getString("nombre"));
                objMedic.setLastName(objResult.getString("apellido"));
                objMedic.setIdEspeciality(objResult.getInt("id_especialidad"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return objMedic;
    }

    @Override
    public List<Object> listAll() {

        Connection objConnection = ConfigDB.openConnection();

        List<Object> medicList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Medicos INNER JOIN Especialidades ON Especialidades.id_especialidad = Medicos.id_especialidad";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Medic objMedic = new Medic();
                Speciality objSpeciality = new Speciality();

                objMedic.setIdMedic(objResult.getInt("Medicos.id_medico"));
                objMedic.setName(objResult.getString("Medicos.nombre"));
                objMedic.setLastName(objResult.getString("Medicos.apellido"));
                objMedic.setIdEspeciality(objResult.getInt("Medicos.id_especialidad"));

                objSpeciality.setIdEspeciality(objResult.getInt("Especialidades.id_especialidad"));
                objSpeciality.setName(objResult.getString("Especialidades.nombre"));
                objSpeciality.setDescription(objResult.getString("Especialidades.descripcion"));

                objMedic.setObjEspeciality(objSpeciality);

                medicList.add(objMedic);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return medicList;
    }

    @Override
    public boolean delete(Object medic) {
        boolean isDeleted = false;

        Medic objMedic = (Medic) medic;

        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "DELETE FROM Medicos WHERE id_medico = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);


            objPrepare.setInt(1, objMedic.getIdMedic());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "The delete was successful");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return isDeleted;
    }
}
