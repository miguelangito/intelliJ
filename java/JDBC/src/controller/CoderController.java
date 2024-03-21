package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;
import java.util.List;

public class CoderController {

    CoderModel objCoderModel = new CoderModel();

    public CoderController() {
        //Crear una instancia del model
        this.objCoderModel = new CoderModel();
    }

    //Método para listar todos los coder
    public void getAll() {
        String list = this.getAll(this.objCoderModel.findAll());
        //Mostramos toda la lista
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> listObject){
        String list = "-- List Coders -- \n";

        //Iteramos sobre la lista que devuelve el método findAll
        for (Object obj : listObject) {

            //Convertimos o casteamos el objeto tipo Object a un Coder
            Coder objCoder = (Coder) obj;

            //Concatenamos la información
            list += objCoder.toString() + "\n";
        }
        return list;
    }

    public void create() {
        Coder objCoder = new Coder();

        String name = JOptionPane.showInputDialog("Insert name: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age: "));
        String clan = JOptionPane.showInputDialog("Insert clan: ");

        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);

        objCoder = (Coder) this.objCoderModel.insert(objCoder);
        JOptionPane.showMessageDialog(null, objCoder.toString());
    }

    public void delete() {
        String list = this.getAll(this.objCoderModel.findAll());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(list + "Enter the ID of the coder you want to delete"));

        Coder objCoder = (Coder) this.objCoderModel.findById(idDelete);

        if (objCoder == null) {
            JOptionPane.showMessageDialog(null, "ID not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the coder; \n" + objCoder.toString());
            if (confirm == 0) {
                this.objCoderModel.delete(objCoder);
            }
        }
    }

    public void find() {

        String nameCoder = JOptionPane.showInputDialog(null, "Enter the name of the coder for search");

        String list = "List Coders: \n";


        for (Object obj : this.objCoderModel.findByName(nameCoder)) {

            Coder objCoder = (Coder) obj;
            list += objCoder.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, list);

    }

    public void update(){
        String list = this.getAll(this.objCoderModel.findAll());


        int idSearch = Integer.parseInt(JOptionPane.showInputDialog("Put the ID of the coder do you want to edit" + list));

        Coder objCoder = (Coder) this.objCoderModel.findById(idSearch);

        if (objCoder == null){
            JOptionPane.showMessageDialog(null,"Coder not found");
        }else {

            String name = JOptionPane.showInputDialog(null,"Insert new name", objCoder.getName());
            int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert new age",String.valueOf(objCoder.getAge())));
            String clan = JOptionPane.showInputDialog(null, "Insert new clan",objCoder.getClan());

            objCoder.setName(name);
            objCoder.setAge(age);
            objCoder.setClan(clan);

            this.objCoderModel.update(objCoder);

            JOptionPane.showMessageDialog(null,"Coder updated");
            JOptionPane.showMessageDialog(null,objCoder);
        }
    }
}
