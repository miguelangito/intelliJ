import controller.AuthorController;
import database.ConfigDB;
import entity.Libro;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();
        AuthorController objAuthorController = new AuthorController();
        String option = "";

        JOptionPane.showMessageDialog(null, "Welcome to the administrator of the library");

        do {
            JOptionPane.showInputDialog(null, "Chose what are you going to do\n" +
                    "1. Authors administration\n" +
                    "2. Books administration\n" +
                    "3. Exit");

            switch (option) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Welcome to the Authors administration system");
                    JOptionPane.showInputDialog(null, "Chose what are you going to do\n" +
                            "1. List authors." +
                            "2. Add new author" +
                            "3. Edit author" +
                            "4. Remove author." +
                            "5. Exit");
                    String option2 = "";
                    switch (option2) {
                        case "1":

                            break;
                    }
                    break;
            }
        } while (option != "3");
    }
}