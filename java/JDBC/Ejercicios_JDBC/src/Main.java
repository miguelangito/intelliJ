import controller.AuthorController;
import database.ConfigDB;
import entity.Libro;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();
        AuthorController objAuthorController = new AuthorController();
        int option = 0;
        int option2 = 0;
        int option3 = 0;
        JOptionPane.showMessageDialog(null, "Welcome to the administrator of the library");

        do {
            JOptionPane.showInputDialog(null, "Chose what are you going to do\n" +
                    "1. Authors administration\n" +
                    "2. Books administration\n" +
                    "3. Exit");

            switch (option) {
                case 1:
                    do {
                        JOptionPane.showMessageDialog(null, "Welcome to the Authors administration system");
                        JOptionPane.showInputDialog(null, "Chose what are you going to do\n" +
                                "1. List authors." +
                                "2. Add new author" +
                                "3. Edit author" +
                                "4. Remove author." +
                                "5. Exit");

                        switch (option2) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                        }
                        break;
                    }while (option2 != 5);
                case 2:
                    do {
                        JOptionPane.showMessageDialog(null, "Welcome to the Books administration system");
                        JOptionPane.showInputDialog(null, "Chose what are you going to do\n" +
                                "1. List of books." +
                                "2. Add new book" +
                                "3. Edit book" +
                                "4. Remove book." +
                                "5. Exit");
                        switch (option3){
                            case 1:

                                break;
                        }
                    }while (option3 != 5);
                    break;
            }
        } while (option != 33);
    }
}