package controller;

import entity.Patient;
import model.PatientModel;

import javax.swing.*;
import entity.Speciality;

import java.sql.Date;

public class PatientController {

    PatientModel objPatientModel = new PatientModel();
    public void create(){
        Patient objPatient = new Patient();

        String name = JOptionPane.showInputDialog("Inset Patient Fist Name");
        String lastName = JOptionPane.showInputDialog("Inset Patient Last Name");
        Date nacDate = Date.valueOf(JOptionPane.showInputDialog("Insert Patient BirthDate (YYYY- MM- DD)"));
        String docNumber = JOptionPane.showInputDialog("Insert Patient Document Number");

        objPatient.setName(name);
        objPatient.setLastName(lastName);
        objPatient.setNacDate(nacDate);
        objPatient.setDocumentNumber(docNumber);

        objPatient = (Patient) this.objPatientModel.create(objPatient);
        JOptionPane.showMessageDialog(null,objPatient.toString());
    }
}
