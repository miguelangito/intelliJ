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

        Patient selectedPatient = (Patient) JOptionPane.showInputDialog(null, "Select a Patient", "", JOptionPane.QUESTION_MESSAGE, null, optionsPatient, optionsPatient[0]);
        Medic selectedMedic = (Medic) JOptionPane.showInputDialog(null, "Select a Medic", "", JOptionPane.QUESTION_MESSAGE, null, optionsMedic, optionsMedic[0]);

        instanceModel().create(new Appointment(selectedPatient.getIdPatient(), motive, selectedPatient, selectedMedic.getIdMedic(), selectedMedic, date, time));
    }

    public static void delete() {
        int confirm = 1;
        Object[] options = Utils.listToArray(instanceModel().listAll());
        Appointment appointmentSelected = (Appointment) JOptionPane.showInputDialog(null, "Select the Appointment to delete", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);


        if (appointmentSelected == null) {
            JOptionPane.showMessageDialog(null, "Appointment not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Appointment: \n" + appointmentSelected);

            if (confirm == 0) {
                instanceModel().delete(appointmentSelected);
            } else {
                JOptionPane.showMessageDialog(null, "The Appointment was not deleted");
            }
        }


    }

    public static void update() {
        Object[] options = Utils.listToArray(instanceModel().listAll());
        Appointment appointmentSelected = (Appointment) JOptionPane.showInputDialog(null, "Select the Appointment to delete", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        appointmentSelected.setCiteDate(Date.valueOf(JOptionPane.showInputDialog(null, "Enter the date of the Appointment YYYY-MM-DD", appointmentSelected.getCiteDate())));
        appointmentSelected.setCiteTime(Time.valueOf(JOptionPane.showInputDialog(null, "Enter the hour of the Appointment HH:MM:SS", appointmentSelected.getCiteTime())));
        appointmentSelected.setMotive(JOptionPane.showInputDialog(null, "Enter the reason of the Appointment", appointmentSelected.getMotive()));

        Object[] optionsPatient = Utils.listToArray(PatientController.instanceModel().listAll());
        appointmentSelected.setObjPatient((Patient) JOptionPane.showInputDialog(null,
                "Select a Patient", "", JOptionPane.QUESTION_MESSAGE, null, optionsPatient, optionsPatient[0]));

        appointmentSelected.setIdPatient(appointmentSelected.getObjPatient().getIdPatient());

        Object[] optionsMedic = Utils.listToArray(MedicController.instanceModel().listAll());
        appointmentSelected.setObjMedic((Medic) JOptionPane.showInputDialog(null,
                "Select a Medic", "", JOptionPane.QUESTION_MESSAGE, null, optionsMedic, optionsMedic[0]));

        appointmentSelected.setIdMedic(appointmentSelected.getObjMedic().getIdMedic());


        instanceModel().update(appointmentSelected);

    }

    public static void findAll() {

        String listString = findAll(instanceModel().listAll());
        JOptionPane.showMessageDialog(null, listString);
    }

    public static String findAll(List<Object> list) {
        String listString = " -- List -- " + "\n";

        for (Object temp : list) {
            Appointment obj = (Appointment) temp;
            listString += "- " + obj.toString() + "\n";
        }
        return listString;
    }

    public static AppointmentModel instanceModel() {
        return new AppointmentModel();
    }

}
