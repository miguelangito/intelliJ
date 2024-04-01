package controller;

import entity.Speciality;
import model.SpecialityModel;

import javax.swing.*;

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

}
