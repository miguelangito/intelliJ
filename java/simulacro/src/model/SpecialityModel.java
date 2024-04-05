package model;

import database.CRUD;
import database.ConfigDB;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpecialityModel implements CRUD {

    @Override
    public Object create(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Speciality objSpeciality = (Speciality) object;

        try {
            String sql = "INSERT INTO Especialidades(nombre, descripcion) VALUES ( ?, ? )";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objSpeciality.getName());
            objPrepare.setString(2, objSpeciality.getDescription());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objSpeciality.setIdEspeciality(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Speciality adding was successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding new Speciality" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objSpeciality;
    }

    @Override
    public List<Object> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public boolean update(Object speciality) {
        Connection objConnection = ConfigDB.openConnection();
        boolean isUpdated = false;

        try {
            String sql = "UPDATE Especialidades SET nombre = ?, descripcion = ? WHERE id_especialidad = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, ((Speciality) speciality).getName());
            objPrepare.setString(2, ((Speciality) speciality).getDescription());
            objPrepare.setInt(3, ((Speciality) speciality).getIdEspeciality());

            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "The update was successful.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Object speciality) {

        boolean isDeleted = false;

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM Especialidades WHERE id_especialidad = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, ((Speciality) speciality).getIdEspeciality());

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

    @Override
    public List<Object> listAll() {

        Connection objConnection = ConfigDB.openConnection();

        List<Object> specialityList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Especialidades ORDER BY Especialidades.id_especialidad ASC";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Speciality objSpeciality = new Speciality();

                objSpeciality.setIdEspeciality(objResult.getInt("id_especialidad"));
                objSpeciality.setName(objResult.getString("nombre"));
                objSpeciality.setDescription(objResult.getString("descripcion"));

                specialityList.add(objSpeciality);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data acquisition error " + e.getMessage());
        }
        ConfigDB.closeConnection();

        return specialityList;
    }

    @java.lang.Override
    public Object findById(int id) {
        Connection objConnection = ConfigDB.openConnection();

        Speciality objSpeciality = null;
        try {

            String sql = "SELECT * FROM  Especialidades WHERE id_especialidad = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, id);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                objSpeciality = new Speciality();
                objSpeciality.setIdEspeciality(objResult.getInt("id_especialidad"));
                objSpeciality.setName(objResult.getString("nombre"));
                objSpeciality.setDescription(objResult.getString("descripcion"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return objSpeciality;
    }
}
