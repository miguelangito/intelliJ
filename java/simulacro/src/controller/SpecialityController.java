package controller;

import entity.Speciality;
import model.SpecialityModel;

import javax.swing.*;
import java.util.List;

public class SpecialityController {

    SpecialityModel objSpecialityModel = new SpecialityModel();

    public void create(){
        Speciality objSpeciality = new Speciality();

        String name = JOptionPane.showInputDialog("Inset Speciality name");
        String description = JOptionPane.showInputDialog("Inset Speciality description");

        objSpeciality.setName(name);
        objSpeciality.setDescription(description);

        objSpeciality = (Speciality) this.objSpecialityModel.create(objSpeciality);
        JOptionPane.showMessageDialog(null,objSpeciality.toString());
    }

    public void delete(){
        String listSpecilityString = this.list(this.objSpecialityModel.listAll());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(null, listSpecilityString+ "\n" + "Select an ID to delete the Speciality"));
        Speciality objSpeciality = (Speciality) this.objSpecialityModel.findById(idDelete);

        if (objSpeciality == null) {
            JOptionPane.showMessageDialog(null, "Speciality not found");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete \n "+ objSpeciality.toString());

            if (confirm == 0) {
                this.objSpecialityModel.delete(objSpeciality);
            }
        }
    }

    public void update(){
        String listSpecialities = this.list(this.objSpecialityModel.listAll());

        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listSpecialities +"\nEnter the ID of the coder to edit"));

        Speciality objSpeciality = (Speciality) this.objSpecialityModel.findById(idUpdate);

        if (objSpeciality == null){
            JOptionPane.showMessageDialog(null, "Speciality not found.");
        }else {
            String name = JOptionPane.showInputDialog(null,"Enter new name",objSpeciality.getName());
            String description = JOptionPane.showInputDialog(null,"Enter new description",objSpeciality.getDescription());

            objSpeciality.setName(name);
            objSpeciality.setDescription(description);

            this.objSpecialityModel.update(objSpeciality);
        }
    }

    public void list(){
        String list = this.list(this.objSpecialityModel.listAll());

        JOptionPane.showMessageDialog(null, list);
    }

    public String list(List<Object> listObject){
        String list = "-- Speciality List -- \n";

        for(Object obj: listObject){
            Speciality objSpeciality = (Speciality) obj;

            list += objSpeciality.toString() + "\n";
        }

        return list;
    }
}
