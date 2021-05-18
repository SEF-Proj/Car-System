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

public class SignUpCus {

    public  static  AccountVerification c = new AccountVerification();

    @FXML
    public Button go_back;
    @FXML
    private Button sign_up;
    @FXML
    private Text id_test1;
    @FXML
    private TextField usrField;
    @FXML
    private PasswordField passField;
    @FXML
    void Sign_up(ActionEvent event) {

        if(usrField.getText().isEmpty() || passField.getText().isEmpty())
        {
            id_test1.setFill(Paint.valueOf("red"));
            id_test1.setText("Please fill all fields");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> id_test1.setText(""));
            pause.play();
        }
        else
        {
            CustomerClass m = new CustomerClass(usrField.getText(), passField.getText());

            // AccountVerification ac = new AccountVerification();
            if (c.AddC(m) == false) {
                id_test1.setFill(Paint.valueOf("red"));
                id_test1.setText("Username already exist");
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> id_test1.setText(""));
                pause.play();
            } else {
                id_test1.setFill(Paint.valueOf("green"));
                id_test1.setText("Account created successfully");
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> id_test1.setText(""));
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
            root4 = FXMLLoader.load(getClass().getResource("/Log In/Customer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root4, 1200, 700);
        stage.setScene(scene);
        stage.show();

    };



}
