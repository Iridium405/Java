package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));

//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10);
//        root.setHgap(10);
//
//        Label greeting = new Label("Welcome to JavaFX Practice.");
//        root.getChildren().add(greeting);
//        greeting.setTextFill(Color.NAVY);
//        greeting.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        primaryStage.setTitle("JavaFX Practice");
        primaryStage.setScene(new Scene(root, 885, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
