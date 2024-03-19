package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {

    @Override
    public Object insert(Object object) {

        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        //4. Preparar el Statement
        Coder objCoder = (Coder) object;

        try {

            //3. Crear sql
            String sql = "INSERT INTO coder(name,age,clan) VALUES(?,?,?)";

            //4. Preparar el Statement
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Asignar los ???
            objPreparedStatement.setString(1,objCoder.getName());
            objPreparedStatement.setInt(2,objCoder.getAge());
            objPreparedStatement.setString(3,objCoder.getClan());

            //6. Ejecutamos el Query
            objPreparedStatement.execute();

            //7. Obtener los resultados
            ResultSet objResult = objPreparedStatement.getGeneratedKeys();

            while (objResult.next()){
                objCoder.setId(objResult.getInt(1));
            }

            objPreparedStatement.close();
            JOptionPane.showMessageDialog(null,"-- Coder Insertion successful --");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"-- Error adding coder -- " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public List<Object> findAll() {
        //1. Abrir la conexión.
        Connection objConnection = ConfigDB.openConnection();

        //2. Inicializar la lista donde se guardaran los registros que devuelve la BD.
        List<Object> listCoders = new ArrayList<>();

        try {
            //3. Escribir la sentencia SQL.
            String sql = "SELECT * FROM coder ORDER BY coder.id ASC;";

            //4. Utilizar PrepareStatement.
            PreparedStatement objPrepareStatement =  (PreparedStatement) objConnection.prepareStatement(sql);

            //5. Ejecutar el Query o el Prepare
            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            //6. obtener los resultados
            while (objResult.next()){

                //Creamos una instancia coder
                Coder objCoder = new Coder();

                //Llenamos nuestro objeto con lo que devuelve la base de datos (ResultSet)
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                //Finalmente agregamos a la lista
                listCoders.add(objCoder);

            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data acquisition Error");
        }
        //7. Cerramos la conexion
        ConfigDB.closeConnection();

        return listCoders;
    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
