package controller;

import entity.Medic;
import entity.Speciality;
import model.MedicModel;
import model.SpecialityModel;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MedicController {

    MedicModel objMedicModel = new MedicModel();
    Speciality objSpeciality = new Speciality();
    SpecialityModel objSpecialityModel = new SpecialityModel();

    public void create() {
        Medic objMedic = new Medic();
        String name = JOptionPane.showInputDialog("Inset Medic Fist Name");
        String lastName = JOptionPane.showInputDialog("Inset Medic Last Name");
        Object[] optionSpecialities = Utils.listToArray(SpecialityController.instanceModel().listAll());

        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(null, "Select the medic Speciality", "", JOptionPane.QUESTION_MESSAGE, null, optionSpecialities, optionSpecialities[0]);

        objMedic.setName(name);
        objMedic.setLastName(lastName);
        objMedic.setIdEspeciality(objSpeciality.getIdEspeciality());
        objMedic.setObjEspeciality(objSpeciality);

        objMedic = this.objMedicModel.create(objMedic);
        JOptionPane.showMessageDialog(null, objMedic.toString());
    }

    public static MedicModel instanceModel() {
        return new MedicModel();
    }

    public static void findAll() {
        String list = findAll(instanceModel().listAll());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String findAll(List<Object> list) {
        String listString = " -- Medic List -- \n";

        for (Object temp : list) {
            Medic objMedic = (Medic) temp;
            listString += objMedic.toString() + "\n";
        }
        return listString;
    }

    public static void delete() {
        Object[] options = Utils.listToArray(instanceModel().listAll());
        Medic objMedic = (Medic) JOptionPane.showInputDialog(null, "Select the Medic to delete", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        instanceModel().delete(objMedic);
    }

    public static void update() {
        Object[] options = Utils.listToArray(instanceModel().listAll());
        Medic objMedic = (Medic) JOptionPane.showInputDialog(null, "Select the Medic to delete", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        String name = JOptionPane.showInputDialog(null, "Enter the new name");
        String lastName = JOptionPane.showInputDialog(null, "Enter the new last name");
        Object[] optionSpecialities = Utils.listToArray(SpecialityController.instanceModel().listAll());

        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(null, "Select the medic Speciality", "", JOptionPane.QUESTION_MESSAGE, null, optionSpecialities, optionSpecialities[0]);

        instanceModel().update(new Medic(name, lastName, objSpeciality.getIdEspeciality(), objSpeciality));
    }
}
