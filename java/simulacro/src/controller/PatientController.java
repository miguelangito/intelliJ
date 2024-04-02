package controller;

import entity.Patient;
import model.PatientModel;

import javax.swing.*;
import entity.Speciality;

import java.sql.Date;
import java.util.List;

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

    public void delete(){
        String listPatientStr = this.list(this.objPatientModel.listAll());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listPatientStr + "Enter the ID of the Patient you want to delete"));
        Patient objPatient = (Patient) this.objPatientModel.findById(idDelete);

        if (objPatient == null) {
            JOptionPane.showMessageDialog(null, "Patient not found");
        }else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the patient: \n"+ objPatient.toString());

            if (confirm == 0) {
                this.objPatientModel.delete(objPatient);
            }
        }
    }

    public void update(){
        String listPatients = this.list(this.objPatientModel.listAll());

        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listPatients + "\n Enter the ID of the patient do you want to edit"));
        Patient objPatient = (Patient) this.objPatientModel.findById(idUpdate);

        if (objPatient == null) {
            JOptionPane.showMessageDialog(null, "Patient not found");
        }else {
            String name = JOptionPane.showInputDialog(null,"Enter the new name", objPatient.getName());
            String lastName = JOptionPane.showInputDialog(null,"Enter the new last name", objPatient.getLastName());
            java.sql.Date date = Date.valueOf(JOptionPane.showInputDialog(null,"Enter the new birth Date", objPatient.getNacDate()));
            String doc_number = JOptionPane.showInputDialog(null,"Enter the new document number", objPatient.getDocumentNumber());

            objPatient.setName(name);
            objPatient.setLastName(lastName);
            objPatient.setNacDate(date);
            objPatient.setDocumentNumber(doc_number);

            this.objPatientModel.update(objPatient);
        }
    }

    public void list(){
        String list = this.list(objPatientModel.listAll());

        JOptionPane.showMessageDialog(null,list);
    }

    public String list(List<Object> listObject){
        String list = "-- Patients list -- \n";

        for (Object obj: listObject){
            Patient objPatient = (Patient) obj;

            list += objPatient.toString() + "\n";
        }
        return list;
    }
}
