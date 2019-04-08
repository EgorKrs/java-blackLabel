package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ForgotYourPasswordController {
    private User user;
    private Parent root;
    @FXML private TextField login;
    @FXML private Label textForUser;
    @FXML private TextField answer;
    @FXML private TextField newPassword;
    @FXML private TextField checkPassword;

    public void finishEditing(){
        if(answer.getText().equals(user.getSecurityAnswer())){
            if (newPassword.getText().equals(checkPassword.getText())){
                user.setPassword(newPassword.getText());
                String sql="UPDATE Users SET password = '"+user.getPassword()+"' WHERE login='"+user.getLogin()+"';";
                try {
                    Statement statement = DatabaseConnection.getObjConnection().getConnection().createStatement();
                    if(statement.executeUpdate(sql)==1){
                        root = FXMLLoader.load(getClass().getResource("Авторизация.fxml"));
                        Scene scene =new Scene(root, 600, 400);
                        PrimaryStage.isExists().changeStage(scene, root);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                textForUser.setText("Пароли не совпадают");
            }
        }
        else{
            textForUser.setText("Не верный ответ");
        }
    }
    public void back(){
        try {
            root = FXMLLoader.load(getClass().getResource("ForgotYourPassword.fxml"));
            Scene scene =new Scene(root, 600, 400);
            PrimaryStage.isExists().changeStage(scene, root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void getUser(){
        user = new User();
        user.setLogin(login.getText());
        String sql="SELECT * FROM Users WHERE login = '"+user.getLogin()+"';";
        Statement statement = null;
        try {
            statement = DatabaseConnection.getObjConnection().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                user.setSecurityQuestion(resultSet.getString(5));
                textForUser.setText(user.getSecurityQuestion());
                user.setSecurityAnswer(resultSet.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
