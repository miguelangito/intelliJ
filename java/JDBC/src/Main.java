import controller.CoderController;
import database.ConfigDB;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();
        CoderController objCoderController = new CoderController();
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    1. List Coders.
                    2. Insert Coder.
                    3. Update Coder.
                    4. Delete Coder.
                    5. Get by name.
                    6. Exit.
                                        
                    Choose an option:
                    """);
            switch (option) {
                case "1": //List all coders
                    objCoderController.getAll();
                    break;
                case "2":
                    objCoderController.create();
                    break;
                case "3":
                    objCoderController.update();
                    break;
                case "4":
                    objCoderController.delete();
                    break;
                case "5":
                    objCoderController.find();
                    break;
            }
        } while (!Objects.equals(option, "6"));
    }
}