package model;

import database.CRUD;
import database.ConfigDB;
import entity.Appointment;
import entity.Medic;
import entity.Patient;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentModel implements CRUD {

    @Override
    public Object create(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Appointment objAppointment = (Appointment) object;

        try {
            String sql = "INSERT INTO Citas ( fecha_cita, hora_cita, motivo , id_paciente , id_medico ) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            objPrepare.setDate(1, objAppointment.getCiteDate());
            objPrepare.setTime(2, objAppointment.getCiteTime());
            objPrepare.setString(3, objAppointment.getMotive());
            objPrepare.setInt(4, objAppointment.getIdPatient());
            objPrepare.setInt(5, objAppointment.getIdMedic());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objAppointment.setIdCite(objResult.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        Connection objConnection = ConfigDB.openConnection();

        Appointment objAppointment = (Appointment) object;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE Citas SET fecha_cita = ?, hora_cita = ?, motivo = ?, id_paciente = ?, id_medico = ? WHERE id_cita = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setDate(1,objAppointment.getCiteDate());
            objPrepare.setTime(2,objAppointment.getCiteTime());
            objPrepare.setString(3,objAppointment.getMotive());
            objPrepare.setInt(4,objAppointment.getIdPatient());
            objPrepare.setInt(5,objAppointment.getIdMedic());
            objPrepare.setInt(6,objAppointment.getIdCite());

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"The Appointment was Updated successfully");
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

        Appointment objAppointment = (Appointment) object;

        boolean isDeleted = false;
        try {
            String sql = "DELETE FROM Citas WHERE id_cita = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objAppointment.getIdCite());
            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"The Appointment was deleted successfully");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List<Object> listAll() {

        Connection objConnection = ConfigDB.openConnection();

        List<Object> listAppointments = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Citas INNER JOIN Pacientes on Pacientes.id_paciente = Citas.id_paciente INNER JOIN Medicos ON Medicos.id_medico =  Citas.id_medico;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Appointment objAppointment = new Appointment();
                Medic objMedic = new Medic();
                Patient objPatient = new Patient();

                objAppointment.setIdCite(objResult.getInt("Citas.id_cita"));
                objAppointment.setCiteDate(objResult.getDate("Citas.fecha_cita"));
                objAppointment.setCiteTime(objResult.getTime("Citas.hora_cita"));
                objAppointment.setMotive(objResult.getString("Citas.motivo"));
                objAppointment.setIdMedic(objResult.getInt("Citas.id_medico"));
                objAppointment.setIdPatient(objResult.getInt("Citas.id_paciente"));

                objMedic.setName(objResult.getString("Medicos.nombre"));
                objPatient.setName(objResult.getString("Pacientes.nombre"));

                objAppointment.setObjPatient(objPatient);
                objAppointment.setObjMedic(objMedic);

                listAppointments.add(objAppointment);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return listAppointments;
    }
}
