package model;

import database.CRUD;
import database.ConfigDB;
import entity.Autor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorModel implements CRUD {
    @java.lang.Override

    public Object insert(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Autor objAuthor = (Autor) object;

        try {
            String sql = "INSERT INTO  authors( name , nationality ) VALUES ( ? , ? );";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objAuthor.getNombre());
            objPrepare.setString(2, objAuthor.getNacionalidad());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objAuthor.setAutorId(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Author insertion was successful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding Author " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAuthor;
    }

    @java.lang.Override
    public boolean update(Object object) {
        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        //2. Convertir el objeto
        Autor objAuthor = (Autor) object;
        //3. Variable bandera para saber si se actualizó
        boolean isUpdated = false;

        try {
            String sql = "UPDATE author SET name = ?, nationality = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objAuthor.getNombre());
            objPrepare.setString(2, objAuthor.getNacionalidad());
            objPrepare.setInt(3, objAuthor.getAutorId());

            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "The update was successful.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @java.lang.Override
    public boolean delete(Object object) {
        Autor objAuthor = (Autor) object;

        boolean isDeleted = false;

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM authors WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objAuthor.getAutorId());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "The delete was successful");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return isDeleted;
    }

    @java.lang.Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> authorList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM authors ORDER BY authors.id ASC;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Autor objAuthors = new Autor();

                objAuthors.setAutorId(objResult.getInt("id"));
                objAuthors.setNombre(objResult.getString("name"));
                objAuthors.setNacionalidad(objResult.getString("nationality"));

                authorList.add(objAuthors);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data acquisition error");
        }
        ConfigDB.closeConnection();
        return authorList;
    }

    @java.lang.Override
    public Object findById(int id) {
        Connection objConnection = ConfigDB.openConnection();

        Autor objAuthor = null;
        try {

            String sql = "SELECT * FROM  authors WERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, id);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                objAuthor = new Autor();
                objAuthor.setAutorId(objResult.getInt("id"));
                objAuthor.setNombre(objResult.getString("name"));
                objAuthor.setNacionalidad(objResult.getString("nationality"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return objAuthor;
    }
}
