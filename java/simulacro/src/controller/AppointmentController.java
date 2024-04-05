package controller;

import entity.Appointment;
import entity.Medic;
import entity.Patient;
import jdk.jshell.execution.Util;
import model.AppointmentModel;
import utils.Utils;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AppointmentController {

    public static void create() {
        Date date = Date.valueOf(JOptionPane.showInputDialog(null, "Enter the date of the Appointment YYYY-MM-DD"));
        Time time = Time.valueOf(JOptionPane.showInputDialog(null, "Enter the hour of the Appointment HH:MM:SS"));
        String motive = JOptionPane.showInputDialog(null, "Enter the reason of the Appointment");

        Object[] optionsPatient = Utils.listToArray(PatientController.instanceModel().listAll());
        Object[] optionsMedic = Utils.listToArray(MedicController.instanceModel().listAll());

        Patient selectedPatient = (Patient) JOptionPane.showInputDialog(null, "Select a Patient", "",
                JOptionPane.QUESTION_MESSAGE, null, optionsPatient, optionsPatient[0]);
        Medic selectedMedic = (Medic) JOptionPane.showInputDialog(null, "Select a Medic", "",
                JOptionPane.QUESTION_MESSAGE, null, optionsMedic, optionsMedic[0]);

        instanceModel().create(new Appointment(selectedPatient.getIdPatient(), motive, selectedPatient, selectedMedic.getIdMedic(), selectedMedic, date, time));
    }

    public static AppointmentModel instanceModel() {
        return new AppointmentModel();
    }

}
