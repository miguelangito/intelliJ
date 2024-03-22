package controller;

import entity.Autor;
import model.AuthorModel;

import javax.swing.*;
import java.util.List;

public class AuthorController {

    AuthorModel objAuthorModel = new AuthorModel();

    public void insert(){
        Autor objAuthor = new Autor();

        String name = JOptionPane.showInputDialog("Insert Author name");
        String nationality = JOptionPane.showInputDialog("Insert Author nationality");

        objAuthor.setNombre(name);
        objAuthor.setNacionalidad(nationality);

        objAuthor = (Autor) this.objAuthorModel.insert(objAuthor);
        JOptionPane.showMessageDialog(null, objAuthor.toString());
    }

    public void list(){
        String list = this.list(this.objAuthorModel.findAll());

        JOptionPane.showMessageDialog(null , list);
    }

    public String list(List<Object> listObject){
        String list = "-- Authors list -- \n";

        for (Object obj:    listObject) {
            Autor objAuthor = (Autor) obj;

            list += objAuthor.toString() + "\n";
        }

        return list;
    }

    public void delete(){
        String listAuthorString = this.list(this.objAuthorModel.findAll());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthorString + "Enter the ID of the author you want to delete"));
        Autor objAuthor = (Autor) this.objAuthorModel.findById(idDelete);

        if (objAuthor == null) {
            JOptionPane.showMessageDialog(null, "Author not found");
        }else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Author:  \n" + objAuthor.toString());

            if (confirm == 0) {
                this.objAuthorModel.delete(objAuthor);
            }
        }
    }

    public void update(){
        String listCoders = this.list(this.objAuthorModel.findAll());

        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listCoders +"\nEnter the ID of the coder to edit"));

        Autor objAuthor = (Autor) this.objAuthorModel.findById(idUpdate);

        if (objAuthor == null){
            JOptionPane.showMessageDialog(null, "Coder not found.");
        }else {
            String name = JOptionPane.showInputDialog(null,"Enter new name",objAuthor.getNombre());
            String nationality = JOptionPane.showInputDialog(null,"Enter new nationality",objAuthor.getNacionalidad());

            objAuthor.setNombre(name);
            objAuthor.setNacionalidad(nationality);

            this.objAuthorModel.update(objAuthor);
        }
    }
}
