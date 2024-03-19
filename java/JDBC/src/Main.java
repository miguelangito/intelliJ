import controller.CoderController;
import databse.ConfigDB;
import model.CoderModel;

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
                    5. Get by ID.
                    6. Exit.
                    
                    Choose an option:
                    """);
            switch (option){
                case "1": //List all coders
                    objCoderController.getAll();
                    break;
                case "2":
                    objCoderController.create();
            }
        }while (!Objects.equals(option, "6"));
    }
}