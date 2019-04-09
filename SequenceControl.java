import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class SequenceControl extends Application {
    private Scene scene;
    private Parent root;
    static int  flag;
    @Override
    public void start(Stage primaryStage) throws Exception{
        if(flag==0)
            root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        else
        root = FXMLLoader.load(getClass().getResource("Авторизация.fxml"));
        scene =new Scene(root, 600, 400);
        sample.PrimaryStage.isExists().changeStage(scene, root);
    }
    public void begin(int flag){
        this.flag=flag;
        launch();
    }

}
