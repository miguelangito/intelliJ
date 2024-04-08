package model;

import database.CRUD;
import database.ConfigDB;
import entity.Airplanes;
import entity.Flights;
import entity.Seat;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsModel implements CRUD {
    AirplanesModel airplaneModel = new AirplanesModel();
    SeatModel seatModel = new SeatModel();

    @Override
    public Object create(Object object) {
        Flights objFlight = (Flights) object;

        Connection connection = ConfigDB.openConnection();

        try {

            //4. Crear el SQL
            String sql = "INSERT INTO vuelos(destino, fecha_salida, hora_salida, id_avion) VALUE(?, ?, ?, ?);";

            //5. Preparar el statement
            PreparedStatement prepared = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //6. Asignar los "?"
            prepared.setString(1, objFlight.getDestiny());
            prepared.setDate(2, objFlight.getDep_date());
            prepared.setTime(3, objFlight.getDep_time());
            prepared.setInt(4, objFlight.getId_plane());

            //7. Ejecutamos el Query
            prepared.execute();

            //8. Obtener el resultado
            ResultSet result = prepared.getGeneratedKeys();
            while (result.next()) {
                objFlight.setId(result.getInt(1));
            }

            Airplanes airplane = (Airplanes) airplaneModel.findById(objFlight.getId_plane());
            List<Seat> seatList = new ArrayList<>();

            //Menor o igual
            for (int i = 1; i <= airplane.getCapacity(); i++) {

                //Creamos el objeto asiento
                Seat seat = new Seat();

                //Asignamos los valores del asiento
                seat.setSeatCode(String.valueOf(i));
                seat.setAvailability(Boolean.TRUE);
                seat.setIdFlight(objFlight.getId_plane());
                seatList.add(seat);
            }

            seatModel.saveAll(seatList);

            //9. Cerramos el prepareStatement

            prepared.close();
            JOptionPane.showMessageDialog(null, "Flight insertion was successful.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding Flight " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objFlight;
    }

    @Override
    public List<Object> listAll() {
        return null;
    }

    @Override
    public boolean update(Object object) {
        Connection connection = ConfigDB.openConnection();

        Flights flight = new Flights();

        boolean isUpdated = false;
        try {

            String sql = "UPDATE vuelos SET destino = ?,  fecha_salida = ?, hora_salida = ?, id_avion = ? WHERE id =?;";

            PreparedStatement prepareCall = connection.prepareStatement(sql);

            prepareCall.setString(1, flight.getDestiny());
            prepareCall.setDate(2, flight.getDep_date());
            prepareCall.setTime(3, flight.getDep_time());
            prepareCall.setInt(4, flight.getId_plane());
            prepareCall.setInt(5, flight.getId());

            prepareCall.execute();

            prepareCall.close();
            JOptionPane.showMessageDialog(null, "Flight update.\n" + flight);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error \n " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {
        Connection connection = ConfigDB.openConnection();

        Flights objFLight = new Flights();
        boolean isDeleted = false;
        try {
            String sql = "DELETE FROM flights WHERE id = ?;";

            PreparedStatement prepareCall = connection.prepareStatement(sql);
            prepareCall.setInt(1, objFLight.getId());
            prepareCall.execute();
            prepareCall.close();

            JOptionPane.showMessageDialog(null, "Flight successfully eliminated\n");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting\n" + e.getMessage());
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



