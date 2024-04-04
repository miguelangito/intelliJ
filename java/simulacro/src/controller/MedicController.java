package controller;

import entity.Medic;
import entity.Speciality;
import model.MedicModel;
import model.SpecialityModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MedicController {

    MedicModel objMedicModel = new MedicModel();
    Speciality objSpeciality = new Speciality();
    SpecialityModel objSpecialityModel = new SpecialityModel();

    public void create(){
        Medic objMedic = new Medic();

        String name = JOptionPane.showInputDialog("Inset Medic Fist Name");
        String lastName = JOptionPane.showInputDialog("Inset Medic Last Name");
        int id = Integer.parseInt(JOptionPane.showInputDialog(objSpecialityModel.listAll().get(objSpeciality.getIdEspeciality()) + "\n Chose an option for the Speciality"));

        objMedic.setName(name);
        objMedic.setLastName(lastName);
        objMedic.setIdEspeciality(id);
        objMedic.setObjEspeciality();

        objMedic = (Medic) this.objMedicModel.create(objMedic);
        JOptionPane.showMessageDialog(null,objMedic.toString());
    }

}
