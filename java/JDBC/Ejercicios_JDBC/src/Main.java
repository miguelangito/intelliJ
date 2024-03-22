import controller.AuthorController;
import database.ConfigDB;
import entity.Libro;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();
        AuthorController objAuthorController = new AuthorController();
        JOptionPane.showMessageDialog(null, "Welcome to the administrator of the library");
        String option;
        do {
            option = JOptionPane.showInputDialog(null, "Chose what are you going to do\n" +
                    "1. Authors administration\n" +
                    "2. Books administration\n" +
                    "3. Exit");
            switch (option) {
                case "1":
                    do {
                        option = JOptionPane.showInputDialog(null, "Chose what are you going to do\n" +
                                "1. List authors.\n" +
                                "2. Add new author\n" +
                                "3. Edit author\n" +
                                "4. Remove author.\n" +
                                "5. Exit");
                        switch (option) {
                            case "1":
                                objAuthorController.list();
                                break;
                            case "2":
                                objAuthorController.insert();
                                break;
                            case "3":
                                objAuthorController.update();
                                break;
                            case "4":
                                objAuthorController.delete();
                                break;
                        }
                        break;
                    } while (!option.equals("5"));
                case "2":
                    do {
                        option = JOptionPane.showInputDialog(null, "Chose what are you going to do\n" +
                                "1. List of books.\n" +
                                "2. Add new book\n" +
                                "3. Edit book\n" +
                                "4. Remove book.\n" +
                                "5. Exit");
                        switch (option) {
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                        }
                    } while (!option.equals("5"));
                    break;
            }
        } while (!option.equals("3"));
    }
}