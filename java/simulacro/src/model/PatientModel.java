package model;

import database.ConfigDB;
import database.PatientCrud;
import entity.Patient;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientModel implements PatientCrud {

    @Override
    public Patient create(Patient patient) {
        Connection objConnection = ConfigDB.openConnection();

        Patient objPatient = (Patient) patient;

        try {
            String sql = "INSERT INTO Pacientes(nombre, apellido, fecha_nac, documento_identidad) VALUES ( ?, ? ,? ,? )";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objPatient.getName());
            objPrepare.setString(2, objPatient.getLastName());
            objPrepare.setDate(3, objPatient.getNacDate());
            objPrepare.setString(4, objPatient.getDocumentNumber());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objPatient.setIdPatient(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null,"Patient was added successfully");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error adding new Patient " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPatient;
    }

    @Override
    public List<Patient> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public void update(Patient patient) {

    }

    @Override
    public void delete(Patient patient) {

    }

    @Override
    public Object findById(int id){
        Connection objConnection = ConfigDB.openConnection();

        Patient objPatient = null;

        try {
            String sql = "SELECT * FROM  Pacientes WHERE id_paciente = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,id);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                objPatient = new Patient();
                objPatient.setIdPatient(objResult.getInt("id_paciente"));
                objPatient.setName(objResult.getString("nombre"));
                objPatient.setLastName(objResult.getString("apellido"));
                objPatient.setNacDate(objResult.getDate("fecha_nac"));
                objPatient.setDocumentNumber(objResult.getString("documento_identidad"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return objPatient;
    }

    @Override
    public List<Object> listAll(){

        Connection objConnection = ConfigDB.openConnection();
        List<Object> patientList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM  Pacientes ORDER BY Pacientes.id_paciente ASC";

            PreparedStatement objPreparare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPreparare.executeQuery();

            while (objResult.next()){
                Patient objPatient = new Patient();

                objPatient.setIdPatient(objResult.getInt("id_paciente"));
                objPatient.setName(objResult.getString("nombre"));
                objPatient.setLastName(objResult.getString("apellido"));
                objPatient.setNacDate(objResult.getDate("fecha_nac"));
                objPatient.setDocumentNumber(objResult.getString("documento_identidad"));

                patientList.add(objPatient);

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data acquisition error " + e.getMessage());
        }
        return patientList;
    }
}
