package model;

import database.ConfigDB;
import database.PatientCrud;
import entity.Patient;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            JOptionPane.showMessageDialog(null,"Patient adding was successful");
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
}
