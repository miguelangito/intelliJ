import controller.MedicController;
import controller.PatientController;
import controller.SpecialityController;
import database.ConfigDB;
import entity.Speciality;
import model.SpecialityModel;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        SpecialityController objSpecialityController = new SpecialityController();
        PatientController objPatientController = new PatientController();
        MedicController objMedicController = new MedicController();
        JOptionPane.showMessageDialog(null, "Welcome to the medic administrator");
       String option;
        do {
            option = JOptionPane.showInputDialog(""" 
                    Chose an option
                    1. Patient administrator.
                    2. Medic administrator.
                    3. Speciality administrator.
                    4. Cite administrator.
                    5. Exit.
                    """);
            switch (option){
                case "1":
                    do {
                        JOptionPane.showMessageDialog(null,"Welcome to the Patients administrator");
                        option = JOptionPane.showInputDialog("""
                                Chose an option
                                1. Add a new patient.
                                2. Change data from a patient.
                                3. Delete a patient profile.
                                4. List all patients.
                                5. Exit.
                                """);
                        switch (option){
                            case "1":
                                objPatientController.create();
                                break;
                            case "2":
                                objPatientController.update();
                                break;
                            case "3":
                                objPatientController.delete();
                                break;
                            case "4":
                                objPatientController.list();
                                break;
                        }
                    }while (!Objects.equals(option, "5"));
                    break;
                case "2":
                    do {
                        JOptionPane.showMessageDialog(null,"Welcome to the Medic administrator");
                        option = JOptionPane.showInputDialog("""
                            Chose an option
                            1. Add a new doctor.
                            2. Change data from a doctor.
                            3. Delete a doctor profile.
                            4. List all doctors.
                            5. Exit.
                            """);
                        switch (option){
                            case "1":
                                objMedicController.create();
                                break;
                            case "2":
                                MedicController.update();
                                break;
                            case "3":
                                MedicController.delete();
                                break;
                            case "4":
                                MedicController.findAll();
                                break;
                        }
                    }while (!Objects.equals(option,"5"));
                    break;
                case "3":
                    do {
                        JOptionPane.showMessageDialog(null, "Welcome to the Speciality administrator");
                        option = JOptionPane.showInputDialog("""
                                 Chose an option
                                 1. Create a new Speciality.
                                 2. Update an already create Speciality.
                                 3. Remove a Speciality
                                 4. List all the Specialities.
                                 5. Exit.
                                 """);
                        switch (option){
                            case "1":
                                objSpecialityController.create();
                                break;
                            case "2":
                                objSpecialityController.update();
                                break;
                            case "3":
                                objSpecialityController.delete();
                                break;
                            case "4":
                                objSpecialityController.list();
                                break;
                        }
                    }while (!Objects.equals(option, "5"));
                    break;
                case "4":
                    do {
                        JOptionPane.showMessageDialog(null, "Welcome to the Cites administrator");
                        option = JOptionPane.showInputDialog("""
                                 Chose an option
                                 1. Create a new Cite.
                                 2. Edit a existing cite.
                                 3. Delete a cite
                                 4. List all the cites.
                                 5. Exit.
                                 """);
                        switch (option){
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                        }
                    }while (!Objects.equals(option, "5"));
                    break;
            }
        }while (!option.equals("5"));
    }
}