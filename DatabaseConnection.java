import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    String url = "jdbc:mysql://localhost/vase?serverTimezone=Europe/Moscow&useSSL=false";
    String username = "root";
    String password = "RootPassword";

    Connection connection;
    private volatile static DatabaseConnection con;
   private DatabaseConnection(){
       try {
           connection = DriverManager.getConnection(url, username, password);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    public static DatabaseConnection getObjConnection(){
        if(con==null ){
            synchronized (sample.PrimaryStage.class) {
                if(con==null )
                    con= new DatabaseConnection();
            }
        }
        return con;
    }
    public Connection getConnection(){
       return connection;
    }

}






