import controller.AirplanesController;
import controller.FlightsController;
import controller.PassengersController;
import controller.ReservationsController;
import model.FlightsModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String option;

        do {

            option = JOptionPane.showInputDialog("""
                    Welcome to Back Flight select the desired option:
                                        
                    1. Airplane Manager
                    2. Flight Manager
                    3. Passenger Administrator
                    4. Reservation Manager
                    5. Exit.
                    """);

            switch (option) {
                case "1":
                    do {
                        option = JOptionPane.showInputDialog("""
                                Welcome to Back Flight!
                                                                
                                Airplanes Manager select the desired option:
                                                                
                                1. Create a new airplanes.
                                2. Update airplanes.
                                3. Delete airplanes.
                                4. Show all airplanes.
                                5. Exit.
                                """);
                        switch (option) {
                            case "1":
                                AirplanesController.create();
                                break;
                            case "2":
                                AirplanesController.update();
                                break;
                            case "3":
                                AirplanesController.delete();
                                break;
                            case "4":
                                AirplanesController.listAll();
                                break;
                        }
                    } while (!option.equals("5"));
                    break;
                case "2":
                    do {
                        option = JOptionPane.showInputDialog("""
                                Welcome to Back Flight!
                                                                
                                Flight Manager select the desired option:
                                                                
                                1. Create a new Flight.
                                2. Filter Flight.
                                3. Update Flight.
                                4. Delete Flight.
                                5. Show all Flight.
                                6. Exit.
                                """);
                        switch (option) {
                            case "1":
                                FlightsController.create();
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                            case "5":
                                break;
                        }
                    } while (!option.equals("6"));
                    break;
                case "3":
                    do {
                        option = JOptionPane.showInputDialog("""
                                Welcome to Back Flight!
                                                                
                                Passenger Administrator select the desired option:
                                                                
                                1. Create a new Passenger.
                                2. Filter Passenger. 
                                3. Update Passenger.
                                4. Delete Passenger.
                                5. Show all Passenger.
                                6. Exit.
                                """);
                        switch (option) {
                            case "1":
                                PassengersController.create();
                                break;
                            case "2":
                                break;
                            case "3":
                                PassengersController.update();
                                break;
                            case "4":
                                PassengersController.delete();
                                break;
                            case "5":
                                PassengersController.listAll();
                                break;
                        }
                    } while (!option.equals("6"));
                    break;
                case "4":
                    do {
                        option = JOptionPane.showInputDialog("""
                                Welcome to Back Flight!
                                                                
                                Reservation Manager select the desired option:
                                                                
                                1. Create a new Reservation.
                                2. Filter Reservation.
                                3. Update Reservation.
                                4. Delete Reservation.
                                5. Show all Reservation.
                                6. Exit.
                                """);
                        switch (option) {
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                            case "5":
                                break;
                        }
                    } while (!option.equals("6"));
                    break;
            }

        } while (!option.equals("5"));
    }
}