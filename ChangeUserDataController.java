package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ChangeUserDataController {
    private Parent root;
    public void changeComplete(){

    }
    public void back() throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainAdminMenu.fxml"));
        Scene scene =new Scene(root, 600, 400);
        PrimaryStage.isExists().changeStage(scene, root);
    }
}
