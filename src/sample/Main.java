package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Rick and Morty");
        primaryStage.setScene(new Scene(root, 602, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    public void addThingIDontKnow()
    {
        System.out.println("seize the means of production");
    }
    public void removeThingIDontKnow()
    {
        System.out.println("seize the means of procreation");
    }
    public void doThingIDontKnow()
    {
        System.out.println("seize the memes of production");
    }
}

