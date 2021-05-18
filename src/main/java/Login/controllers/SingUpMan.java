package Login.controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SingUpMan {

  public static  AccountVerification ac = new AccountVerification();


    @FXML
    public Button go_back;

    @FXML
    private Button sign_up;

    @FXML
    private Text id_test2;
    @FXML
    private TextField Textfield1;

    @FXML
    private PasswordField TextField2;

    @FXML
    private TextField TextField3;

    @FXML
    void Sign_up(ActionEvent event) {


        if(Textfield1.getText().isEmpty() || TextField2.getText().isEmpty() || TextField3.getText().isEmpty())
        {
            id_test2.setFill(Paint.valueOf("red"));
            id_test2.setText("Please fill all fields");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> id_test2.setText(""));
            pause.play();
        }
        else
        {
            ManufacturerClass m = new ManufacturerClass(TextField3.getText(), Textfield1.getText(), TextField2.getText());



           //static AccountVerification ac = new AccountVerification();
            if (!ac.AddM(m)) {
                id_test2.setFill(Paint.valueOf("red"));
                id_test2.setText("Username or ID already exist");
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> id_test2.setText(""));
                pause.play();
            } else {
                id_test2.setFill(Paint.valueOf("green"));
                id_test2.setText("Account created successfully");
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> id_test2.setText(""));
                pause.play();

            }
        }

    }


    @FXML
    void back(ActionEvent event) {

        Stage stage = (Stage) go_back.getScene().getWindow();
        //stage.setTitle("");

        Parent root4 = null;
        try {
            root4 = FXMLLoader.load(getClass().getResource("/Log In/Manufacturer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root4, 1200, 700);
        stage.setScene(scene);
        stage.show();

    };


}
