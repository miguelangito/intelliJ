package model;

import database.CRUD;
import database.ConfigDB;
import entity.Appointment;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class AppointmentModel implements CRUD {

    @Override
    public Object create(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Appointment objAppointment = (Appointment) object;

        try {
            String sql = "INSERT INTO Citas ( fecha_cita, hora_cita, motivo , id_paciente , id_medico ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            objPrepare.setDate(1, objAppointment.getCiteDate());
            objPrepare.setTime(2,objAppointment.getCiteTime());
            objPrepare.setString(3,objAppointment.getMotive());
            objPrepare.setInt(4,objAppointment.getIdPatient());
            objPrepare.setInt(5,objAppointment.getIdMedic());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objAppointment.setIdCite(objResult.getInt(1));
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAppointment;
    }

    @Override
    public List<Object> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List<Object> listAll() {
        return null;
    }
}
