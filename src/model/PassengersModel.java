package model;

import database.CRUD;
import database.ConfigDB;
import entity.Passengers;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengersModel implements CRUD {
    @Override
    public Object create(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Passengers objPassengers = (Passengers) object;

        try {
            String sql = "INSERT INTO pasajeros ( nombre, apellido, documento_identidad ) VALUES ( ? , ? , ? );";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objPassengers.getName());
            objPrepare.setString(2, objPassengers.getLastName());
            objPrepare.setString(3, objPassengers.getDocumentNumber());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objPassengers.setId(objResult.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPassengers;
    }

    @Override
    public List<Object> listAll() {
        Connection connection = ConfigDB.openConnection();

        List<Object> passengersList = new ArrayList<>();

        try {

            String sql = "SELECT * FROM pasajeros ORDER BY pasajeros.id ASC;";
            PreparedStatement prepared = connection.prepareStatement(sql);

            ResultSet result = prepared.executeQuery();

            while (result.next()) {

                Passengers passengers = new Passengers();

                passengers.setName(result.getString("nombre"));
                passengers.setLastName(result.getString("apellido"));
                passengers.setDocumentNumber(result.getString("documento_identidad"));

                passengersList.add(passengers);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConfigDB.closeConnection();
        return passengersList;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Passengers objPassengers = (Passengers) object;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE pasajeros SET nombre = ?, apellido = ?, documento_identidad = ? WHERE id = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objPassengers.getName());
            objPrepare.setString(2, objPassengers.getLastName());
            objPrepare.setString(3, objPassengers.getDocumentNumber());


            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "The Passenger was Updated successfully");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Passengers objPassengers = (Passengers) object;

        boolean isDeleted = false;
        try {
            String sql = "DELETE FROM pasajeros WHERE id = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objPassengers.getId());
            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "The passenger was deleted successfully");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
    }

    @Override
    public List<Object> filter(String filter, String value) {
//        String sql;
//
//        List<Object> passengerList = new ArrayList<>();
//
//        try {
//
//            if (Objects.equals(filter, "nombre")) {
//
//                sql = "SELECT * FROM pasajeros WHERE nombre LIKE ?;";
//
//                passengerList = findByName(sql, value);
//            }
//            if (Objects.equals(filter, "apellido")) {
//
//                sql = "SELECT * FROM pasajeros WHERE apellido LIKE ?;";
//
//                passengerList = findByLastName(sql, value);
//            }
//        }catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error to apply filter " + e.getMessage());
//        }
//
//        ConfigDB.closeConnection();
//        return passengerList;
        return null;
    }

//    private List<Object> findByName(String sql, String value) {
//
//        Connection connection = ConfigDB.openConnection();
//        List<Object> passengerList = new ArrayList<>();
//
//        try {
//            PreparedStatement prepareCall = connection.prepareStatement(sql);
//            prepareCall.setString(1, "%" + value + "%");
//            ResultSet objResult = prepareCall.executeQuery();
//
//            while (objResult.next()) {
//
//                Passengers passenger = new Passengers();
//
//                passenger.setId(objResult.getInt("id"));
//                passenger.setName(objResult.getString("nombre"));
//                passenger.setLastName(objResult.getString("apellido"));
//                passenger.setDocumentNumber(objResult.getString("documento_identidad"));
//
//                passengerList.add(passenger);
//            }
//
//            prepareCall.close();
//            JOptionPane.showMessageDialog(null, "List of passengers: " + passengerList);
//
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error to show the filter" + e.getMessage());
//
//        }
//
//        return passengerList;
//    }
//
//    private List<Object> findByLastName(String sql, String value) {
//        Connection connection = ConfigDB.openConnection();
//        List<Object> passengerList = new ArrayList<>();
//
//        try {
//            PreparedStatement prepareCall = connection.prepareStatement(sql);
//            prepareCall.setString(1, "%" + value + "%");
//            ResultSet objResult = prepareCall.executeQuery();
//
//            while (objResult.next()) {
//
//                Passengers passenger = new Passengers();
//
//                passenger.setId(objResult.getInt("id"));
//                passenger.setName(objResult.getString("name"));
//                passenger.setLastName(objResult.getString("apellido"));
//                passenger.setDocumentNumber(objResult.getString("documento_identidad"));
//
//                passengerList.add(passenger);
//            }
//
//            prepareCall.close();
//            JOptionPane.showMessageDialog(null, "List of passengers: " + passengerList);
//
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error to show the filter " + e.getMessage());
//
//        }
//
//        return passengerList;
//    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
