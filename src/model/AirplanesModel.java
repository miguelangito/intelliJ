package model;

import database.CRUD;
import database.ConfigDB;
import entity.Airplanes;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplanesModel implements CRUD {
    @Override
    public Object create(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Airplanes objAirplanes = (Airplanes) object;

        try {
            String sql = "INSERT INTO aviones ( modelo, capacidad ) VALUES ( ? , ? );";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objAirplanes.getModel());
            objPrepare.setInt(2, objAirplanes.getCapacity());


            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objAirplanes.setId(objResult.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAirplanes;
    }

    @Override
    public List<Object> listAll() {
        Connection connection = ConfigDB.openConnection();

        List<Object> airplaneList = new ArrayList<>();

        try{

            String sql = "SELECT * FROM aviones ORDER BY aviones.id ASC;";
            PreparedStatement prepared = connection.prepareStatement(sql);

            ResultSet result = prepared.executeQuery();

            while (result.next()){

                Airplanes airplanes = new Airplanes();

                airplanes.setId(result.getInt("id"));
                airplanes.setModel(result.getString("modelo"));
                airplanes.setCapacity(result.getInt("capacidad"));

                airplaneList.add(airplanes);
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConfigDB.closeConnection();
        return airplaneList;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Airplanes objAppointment = (Airplanes) object;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE aviones SET modelo = ?, capacidad = ? WHERE id = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objAppointment.getModel());
            objPrepare.setInt(2,objAppointment.getCapacity());


            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"The Airplane was Updated successfully");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Airplanes objAirplanes = (Airplanes) object;

        boolean isDeleted = false;
        try {
            String sql = "DELETE FROM aviones WHERE id = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objAirplanes.getId());
            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"The Airplane was deleted successfully");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
    }

    @Override
    public List<Object> filter(String filter, String value) {
        return null;
    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
