import controller.SpecialityController;
import database.ConfigDB;
import entity.Speciality;
import model.SpecialityModel;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        SpecialityController objSpecialityController = new SpecialityController();

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
                    break;
                case "2":
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
                        }
                    }while (!Objects.equals(option, "5"));
                    break;
                case "4":
                    break;

            }
        }while (!option.equals("5"));


    }
}