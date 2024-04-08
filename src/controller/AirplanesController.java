package controller;

import entity.Airplanes;
import model.AirplanesModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class AirplanesController {

    AirplanesModel objAirplaneModel = new AirplanesModel();

    public static void create(){
        Airplanes objAirplane = new Airplanes();

        String model = JOptionPane.showInputDialog(null,"Enter the Airplane model");
        int capacity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Airplane capacity"));

        objAirplane.setModel(model);
        objAirplane.setCapacity(capacity);

        instanceModel().create(objAirplane);
        JOptionPane.showMessageDialog(null,objAirplane.toString());

    }

    public static void delete(){
        int confirm = 1;
        Object[] options = Utils.listToArray(instanceModel().listAll());
        Airplanes airplaneSelected = (Airplanes) JOptionPane.showInputDialog(null, "Select the Airplane to delete", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (airplaneSelected == null) {
            JOptionPane.showMessageDialog(null, "Airplane not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Airplane: \n" + airplaneSelected);

            if (confirm == 0) {
                instanceModel().delete(airplaneSelected);
            } else {
                JOptionPane.showMessageDialog(null, "The Airplane was not deleted");
            }
        }

    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().listAll());
        Airplanes airplanesSelected = (Airplanes) JOptionPane.showInputDialog(null, "Select the Airplane to update", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        airplanesSelected.setModel(JOptionPane.showInputDialog(null,"Enter the new model"));
        airplanesSelected.setCapacity(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the new capacity")));

        instanceModel().update(airplanesSelected);
    }

    public static void listAll(){

        String listString = listAll(instanceModel().listAll());
        JOptionPane.showMessageDialog(null, listString);

    }

    public static String listAll(List<Object> list){

        String listString = " -- list -- " + "\n";

        for (Object temp: list){
            Airplanes obj =(Airplanes) temp;
            listString += obj.toString() + "\n";
        }

        return listString;
    }

    public static AirplanesModel instanceModel() {
        return new AirplanesModel();
    }

}
