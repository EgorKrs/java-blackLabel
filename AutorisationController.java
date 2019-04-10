<<<<<<< HEAD
=======
package sample;

>>>>>>> parent of 7d9b2b4... Add files via upload
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutorisationController {
    private sample.User user;
    private Parent root;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Label errorTextField;

//SELECT * FROM Users WHERE [field name] = "whatever";
    public void autrization(ActionEvent actionEvent) throws IOException {
<<<<<<< HEAD
        user = new sample.User();
=======
        user = new User();
>>>>>>> parent of 7d9b2b4... Add files via upload
        user.setPassword(password.getText());
        user.setLogin(login.getText());
        String sql="SELECT * FROM Users WHERE login = '"+user.getLogin()+"';";

        Statement statement = null;
        try {
            statement = DatabaseConnection.getObjConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                if(resultSet.getString(2).equals(user.getPassword())){
                    root = FXMLLoader.load(getClass().getResource("MainAdminMenu.fxml"));
                    Scene scene =new Scene(root, 600, 400);
                    sample.PrimaryStage.isExists().changeStage(scene, root);
                    // erererr
                }
                else{
                    errorTextField.setText("Неверный пароль");
                }
            }
            else{
                errorTextField.setText("Несуществующий логин");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}

