package controller;

import entity.Airplanes;
import entity.Passengers;
import model.AirplanesModel;
import model.PassengersModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class PassengersController {

static PassengersModel objPassengerModel = new PassengersModel();

    public static void create(){
        Passengers objPassenger = new Passengers();

        String name = JOptionPane.showInputDialog(null,"Enter the Passenger name");
        String lastName = JOptionPane.showInputDialog(null, "Enter the Passenger last name");
        String document_number = JOptionPane.showInputDialog(null, "Enter the Passenger document number");

        objPassenger.setName(name);
        objPassenger.setLastName(lastName);
        objPassenger.setDocumentNumber(document_number);

        instanceModel().create(objPassenger);
        JOptionPane.showMessageDialog(null,objPassenger.toString());

    }

    public static void delete(){
        int confirm = 1;
        Object[] options = Utils.listToArray(instanceModel().listAll());
        Passengers passengerSelected = (Passengers) JOptionPane.showInputDialog(null, "Select the Passengers to delete", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (passengerSelected == null) {
            JOptionPane.showMessageDialog(null, "Passengers not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Passengers: \n" + passengerSelected);

            if (confirm == 0) {
                instanceModel().delete(passengerSelected);
            } else {
                JOptionPane.showMessageDialog(null, "The Passengers was not deleted");
            }
        }

    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().listAll());
        Passengers passengerSelected = (Passengers) JOptionPane.showInputDialog(null, "Select the Airplane to update", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        passengerSelected.setName(JOptionPane.showInputDialog(null,"Enter the new model"));
        passengerSelected.setLastName(JOptionPane.showInputDialog(null,"Enter the new capacity"));
        passengerSelected.setDocumentNumber(JOptionPane.showInputDialog(null,"Enter the new capacity"));

        instanceModel().update(passengerSelected);
    }

    public static void listAll(){

        String listString = listAll(instanceModel().listAll());
        JOptionPane.showMessageDialog(null, listString);

    }

    public static String listAll(List<Object> list){

        String listString = " -- list -- " + "\n";

        for (Object temp: list){
            Passengers obj =(Passengers) temp;
            listString += obj.toString() + "\n";
        }

        return listString;
    }

//    public static void filter(){
//        String[] options = {"Name", "Last name"};
//
//        String selectedFilter = (String) JOptionPane.showInputDialog(null, "Select the filter\n", "Filter", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//
//        String valueFilter = JOptionPane.showInputDialog(null, "Insert necessary information\n" + "(name passenger, lastName)");
//
//        List<Object> listPassenger = objPassengerModel.filter(selectedFilter, valueFilter);
//
//        JOptionPane.showMessageDialog(null, listPassenger.toString());
//    }

    public static PassengersModel instanceModel() {
        return new PassengersModel();
    }


}
