package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private TextField nameField;
    @FXML
    private CheckBox clearFieldCheckBox;
    @FXML
    private Label nothingHappenedLabel;



    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent event) {
        if (event.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        } else if (event.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("Going sleep in " + s);
                    Thread.sleep(3000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            nothingHappenedLabel.setText("Something happened!");
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("Executing in " + s);
                        }
                    });
                } catch (InterruptedException ex) {
                    //stacktrace
                }
            }
        };

        new Thread(task).start();


        if(clearFieldCheckBox.isSelected()) {
            nameField.clear();
            initialize();
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    public void handleChange() {
        System.out.println("The checkbox is " + (clearFieldCheckBox.isSelected() ? "checked." : "not checked."));
    }
}
