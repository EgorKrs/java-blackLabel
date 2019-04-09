import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        int flag=1;
        boolean f;
        String url = "jdbc:mysql://localhost/vase?serverTimezone=Europe/Moscow&useSSL=false";
        String username = "root";
        String sad_truth = "egor_sasat";
        System.out.println(sad_truth);
        System.out.println(sad_truth);
        System.out.println(sad_truth);
        System.out.println(sad_truth);
        System.out.println(sad_truth);
        String password = "RootPassword";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "CREATE DATABASE IF NOT EXISTS vase;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql= "CREATE TABLE IF NOT EXISTS Users (login VARCHAR(20) PRIMARY KEY , password VARCHAR(20),"+
                    "access_rights VARCHAR(20),post VARCHAR(20))";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            sql="SELECT * FROM Users;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
               flag=1;
            }
            else flag = 0;

        }

         catch(Exception ex){
        System.out.println("ERROR...");

        System.out.println(ex);
    }
        SequenceControl sequenceControl=new SequenceControl();
        sequenceControl.begin(flag);
    }
}
