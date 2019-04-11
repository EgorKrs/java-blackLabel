<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
package sample;

>>>>>>> parent of 7d9b2b4... Add files via upload
import javafx.event.ActionEvent;
=======
package sample;

>>>>>>> parent of 76b0058... Merge pull request #1 from Pburua/NewBranch1
=======
package sample;

>>>>>>> parent of 76b0058... Merge pull request #1 from Pburua/NewBranch1
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
    private User user;
    private Parent root;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Label errorTextField;

<<<<<<< HEAD
<<<<<<< HEAD
//SELECT * FROM Users WHERE [field name] = "whatever";
    public void autrization(ActionEvent actionEvent) throws IOException {
<<<<<<< HEAD
        user = new sample.User();
=======
        user = new User();
>>>>>>> parent of 7d9b2b4... Add files via upload
=======
    public void authorization() throws IOException {
        user = new User();
>>>>>>> parent of 76b0058... Merge pull request #1 from Pburua/NewBranch1
=======
    public void authorization() throws IOException {
        user = new User();
>>>>>>> parent of 76b0058... Merge pull request #1 from Pburua/NewBranch1
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
                    PrimaryStage.isExists().changeStage(scene, root);
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
    public void registration(){
        try {
            root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene =new Scene(root, 600, 400);
        PrimaryStage.isExists().changeStage(scene, root);
    }
    public void recoveryPassword(){
        try {
            root = FXMLLoader.load(getClass().getResource("ForgotYourPassword.fxml"));
            Scene scene =new Scene(root, 600, 400);
            PrimaryStage.isExists().changeStage(scene, root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

