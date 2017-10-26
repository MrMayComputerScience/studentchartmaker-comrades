package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class Main extends Application {

    private Stage stage;
    boolean showed = false;
    private ObservableList<String> tasks = FXCollections.observableArrayList();
    private HashMap<File, Integer> colmap = new HashMap<>();
    @FXML ListView<String> listView;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Attendance Sheet by Comrades");
        primaryStage.setScene(new Scene(root, 602, 400));
        primaryStage.show();
        stage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void addThingIDontKnow()
    {
        if(!showed) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("What sort of folder should be selected?");
            alert.setContentText("The folder you select should contain three input files:\n" +
                    " - header.txt (header for the page)\n" +
                    " - names.txt (list of student names)\n" +
                    " - columns.txt (optional, list of column titles)\n\n" +
                    "If you do not include columns.txt, you will be asked to input a number of empty columns to be used.");
            alert.showAndWait();
            showed = true;
        }

        DirectoryChooser fileChooser = new DirectoryChooser();
        fileChooser.setTitle("Select Folder");
        File f = fileChooser.showDialog(stage);

        boolean check1 = new File(f, "header.txt").exists();
        boolean check2 = new File(f, "names.txt").exists();
        boolean check3 = new File(f, "columns.txt").exists();

        if(!check1 || !check2) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The folder you selected is invalid.");
            alert.setContentText("Your selected folder is missing either students.txt or header.txt.");
            alert.showAndWait();
            return;
        }

        if(!check3) {
            TextInputDialog dialog = new TextInputDialog("5");
            dialog.setTitle("Column Count Select");
            dialog.setHeaderText("How many columns would you like?");
            dialog.setContentText("Since you provided no columns.txt, you must now specify how many (empty) columns you would like.");
            Optional<String> result = dialog.showAndWait();

            if(result.isPresent()) {
                colmap.put(f, Integer.parseInt(result.get()));
            } else {
                colmap.put(f, 5);
            }
        }

        if(f != null) {
            tasks.add(f.getPath());
            listView.setItems(tasks);
        }
    }

    public void removeThingIDontKnow()
    {
        int i = tasks.indexOf(listView.getSelectionModel().getSelectedItem());

        if(i < 0 || i >= tasks.size()) return;
        else tasks.remove(i);
    }

    public void doThingIDontKnow()
    {
        DataStore ds = new DataStore();

        for(String dir : listView.getItems()) {
            File f = new File(dir);
            System.out.println("Directory - " + dir);

            String header = InputReader.getHeader(dir);
            String[] names = InputReader.getNames(dir);
            String[] columns;

            try {
                columns = InputReader.getColumns(dir);
            } catch (Exception e) {
                columns = new String[colmap.get(f)];
                for (int i = 0; i < columns.length; i++) {
                    columns[i] = " ";
                }
            }

            names = ArraySorter.getFinalFromStart(names);
            ds.tables.add(new Table(header, columns, names));
        }

        Htmlinator.output(ds);
    }
}

