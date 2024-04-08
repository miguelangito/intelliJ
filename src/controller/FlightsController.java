package controller;

import entity.Airplanes;
import entity.Flights;
import model.AirplanesModel;
import model.FlightsModel;
import utils.Utils;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlightsController {

    static AirplanesModel airplanesModel = new AirplanesModel();
    static FlightsModel objFLights = new FlightsModel();

    public static void create(){
        Flights flight = new Flights();

        String destination = JOptionPane.showInputDialog(null, "Enter the destination flight\n");
        Date departureDate = Date.valueOf(LocalDate.parse(JOptionPane.showInputDialog(null, "Enter the departure date (YYYY-MM-DD)\n")));
        Time departureTime = Time.valueOf(LocalTime.parse(JOptionPane.showInputDialog(null, "Enter the departure time (HH:00:SS)\n")));

        Object[] options = Utils.listToArray(AirplanesController.instanceModel().listAll());
        Airplanes selectedPlane = (Airplanes) JOptionPane.showInputDialog(null, "Select the plane \n", "Filter", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);


        flight.setDestiny(destination);
        flight.setDep_date(departureDate);
        flight.setDep_time(departureTime);
        flight.setId_plane(selectedPlane.getId());

        instanceModel().create(flight);
    }

    public static FlightsModel instanceModel(){
        return new FlightsModel();
    }

}
