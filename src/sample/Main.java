package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    private Stage stage;
    private File currentFile;
    private ObservableList<String> tasks = FXCollections.observableArrayList();
    @FXML
    ListView<String> listView;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Rick and Morty");
        primaryStage.setScene(new Scene(root, 602, 400));
        primaryStage.show();
        stage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
    public void addThingIDontKnow()
    {
        DirectoryChooser fileChooser = new DirectoryChooser();
        fileChooser.setTitle("Open Resource File");
        File f = fileChooser.showDialog(stage);
        tasks.add(f.getPath());
        listView.setItems(tasks);


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

