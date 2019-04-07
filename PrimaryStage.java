package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryStage {
    private volatile static PrimaryStage objectPrimaryStage;
    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    private PrimaryStage(){
        primaryStage=new Stage();
    }
    public static PrimaryStage isExists(){
        if(objectPrimaryStage==null ){
            synchronized (PrimaryStage.class) {
                if(objectPrimaryStage==null )
                objectPrimaryStage = new PrimaryStage();
            }
        }
        return objectPrimaryStage;
    }
    public void changeStage(Scene scene, Parent root){
        this.scene=scene;
        this.root=root;
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
