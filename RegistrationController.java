package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationController {
    @FXML public TextField newLogin;
    @FXML private PasswordField newPassword;
    @FXML private PasswordField checkPassword;
    @FXML private Label errorTextField;
    @FXML private Label coolTextField;
    @FXML private TextField securityQuestion;
    @FXML private TextField securityAnswer;
    @FXML private TextField position;
    private String accessRight;
    private Parent root;



    public void registrationComplete(ActionEvent actionEvent){
        coolTextField.setText("");
        errorTextField.setText("");
    User newUser=new User();
    newUser.setLogin(newLogin.getText());
    newUser.setPassword(newPassword.getText());
    newUser.setAccessRight(accessRight);
    newUser.setSecurityAnswer(securityAnswer.getText());
    newUser.setSecurityQuestion(securityQuestion.getText());
    newUser.setPosition(position.getText());
    String sql;
    sql="SELECT * FROM Users WHERE login = '"+newUser.getLogin()+"';";
        Statement statement=null;
        ResultSet resultSet=null;
        try {
             statement = DatabaseConnection.getObjConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(newUser.getLogin().length()==0)  errorTextField.setText("Введите логин");
    else if(newUser.getPassword().length()==0) errorTextField.setText("Введите пароль");
    else if(!newPassword.getText().equals(checkPassword.getText())) errorTextField.setText("Пароли не совпадают");
    else if(newUser.getAccessRight()==null) errorTextField.setText("Выберите права доступа");
    else if(newUser.getSecurityAnswer().length()==0) errorTextField.setText("Введите ответ на секретный ответ");
    else if(newUser.getSecurityQuestion().length()==0) errorTextField.setText("Введите секретный вопрос");
    else if(newUser.getPosition().length()==0) errorTextField.setText("Введите должность");
    else {
            try {
                if(resultSet.next())errorTextField.setText("Такой логин уде существует");

                else {
                    sql = "INSERT Users (login , password , access_rights ,post , security_question ,security_answer ) "+
                            "VALUES ('"+newUser.getLogin()+"','"+newUser.getPassword()+"','"+newUser.getAccessRight()+"','"+newUser.getPosition()+"','"+newUser.getSecurityQuestion()+"','"+newUser.getSecurityAnswer()+"');";
                    PreparedStatement preparedStatement = null;
                    try {
                        preparedStatement = DatabaseConnection.getObjConnection().getConnection().prepareStatement(sql);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        preparedStatement.executeUpdate();
                    coolTextField.setText("Пользователь успешно добавлен");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void back() throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainAdminMenu.fxml"));
        Scene scene =new Scene(root, 600, 400);
        PrimaryStage.isExists().changeStage(scene, root);
    }
    public void setAdmin(){
        accessRight="Admin";
    }
    public void setUser(){
        accessRight="User";
    }
    public void setExpert(){
        accessRight="Expert";
    }
}
