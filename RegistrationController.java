package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class RegistrationController {
    @FXML private Button returnButton;
    @FXML private Button registerButton;
    private Parent root;
    public void registrationComplete(){

    }
    public void back() throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainAdminMenu.fxml"));
        Scene scene =new Scene(root, 600, 400);
        PrimaryStage.isExists().changeStage(scene, root);
    }
}
