package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // if write full directory (../../resources/fxml/sample.fxml) will cause error. WHY
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
//        Group root = new Group();
//        // create a label
//        Label label = new Label("Name: ");
//        // create a "Text" node
//        Text txt = new Text("Sup?");
//        txt.setY(50);               // shift the "txt" node 50 pixel
//        txt.setFont(new Font("Papyrus", 80));
//        // create a "TextField" node
//        TextField nameFld = new TextField();
//        // create a "Button" node
//        Button btn = new Button();
//        btn.setText("Say Sup!");
//        btn.setOnAction(event -> System.out.printf("Sup %s", nameFld.getText()));
//        // create a GridPane
//        GridPane grid = new GridPane();
//        grid.add(label, 0, 0);      // add "label" at position (0, 0) (column, row)
//        grid.add(nameFld, 1, 0);
//        grid.add(btn, 1, 1);
//        grid.setHgap(20);           // set Horizontal gap
////        grid.setGridLinesVisible(true);
//
//        // create a vertical box node
//        VBox box = new VBox();
//        // add all the nodes to the VBox
//        box.getChildren().addAll(txt, grid);
//        // add VBox to the root
//        root.getChildren().add(box);

        primaryStage.setTitle("Sup");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
