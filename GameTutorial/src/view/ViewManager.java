package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;

public class ViewManager {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;


    public ViewManager() {
        this.mainPane = new AnchorPane();
        this.mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        this.mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButtons();
    }


    public Stage getMainStage() {
        return mainStage;
    }


    private void createButtons() {
        Button button1 = new Button();
        button1.setDefaultButton(true);
        mainPane.getChildren().add(button1);
    }
}
