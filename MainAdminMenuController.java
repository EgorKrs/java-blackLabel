package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import sample.PrimaryStage;

import java.io.IOException;

public class MainAdminMenuController{
@FXML private Button newUserButton;
    private Parent root;
    private Scene scene;
    public MainAdminMenuController() {
        
    }
    public void registration() {
        try {
            root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene =new Scene(root, 600, 400);
        PrimaryStage.isExists().changeStage(scene, root);
    }
    public void editingDataUser(){
        try {
            root = FXMLLoader.load(getClass().getResource("ChangeUserData.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene =new Scene(root, 600, 400);
        PrimaryStage.isExists().changeStage(scene, root);
    }
    public void deliteDataUser(){
        try {
            root = FXMLLoader.load(getClass().getResource("DelUser.fxml"));
            scene =new Scene(root, 600, 400);
            PrimaryStage.isExists().changeStage(scene, root);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
