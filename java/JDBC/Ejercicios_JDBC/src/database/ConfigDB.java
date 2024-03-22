package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    //Variable que va a contener el estado de la conexión

    static Connection objConnection = null;

    //Método para abrir la conexión entre Java y la base de datos

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://bzoaestckd3oxex7rh8i-mysql.services.clever-cloud.com:3306/bzoaestckd3oxex7rh8i";
            String user = "ucr0dcbjl8rgmwpm";
            String password = "KWsafzxoqLqrEsdQQGDF";

            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Conectado perfectamente");
        }catch (ClassNotFoundException e ){
            System.out.println("Error >> Driver no instalado " + e.getMessage());
        }catch (SQLException e){
            System.out.println("Error >> no se pudo establecer una conexión con la bd");
        }
        return objConnection;
    }


    public static void closeConnection(){
        try {
            if (objConnection != null) objConnection.close();

        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
