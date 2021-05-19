package Login.controllers;

import Accessories_Details_Controllers.*;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;

public class Manufacturer {


    SingUpMan s = new SingUpMan();
    AccountVerification a = s.ac;
   static ManufacturerClass manu;
    ManufacturerController man = new ManufacturerController();


    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public TextField IDField;

    @FXML
    public Text loginMessage;

    @FXML
    public Button sign_in;

    @FXML
    public Button go_back;

    @FXML
    public Button sign_up_m;



    @FXML
    void Sign_up_m(ActionEvent event) {

        Stage stage = (Stage) sign_up_m.getScene().getWindow();
        stage.setTitle("Manufacturer account");

        Parent root3 = null;
        try {
            root3 = FXMLLoader.load(getClass().getResource("/Log In/makeaccountman.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root3, 1200, 700);
        stage.setScene(scene);
        stage.show();

    };

    @FXML
     void back(ActionEvent event) {

        Stage stage = (Stage) go_back.getScene().getWindow();
        //stage.setTitle("LogIn");

        Parent root4 = null;
        try {
            root4 = FXMLLoader.load(getClass().getResource("/Log In/Login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root4, 1200, 700);
        stage.setScene(scene);
        stage.show();

    };



    @FXML
    void Sign_in(ActionEvent event){
    ManufacturerClass m = new ManufacturerClass(IDField.getText(), usernameField.getText(), passwordField.getText());
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty() || IDField.getText().isEmpty())
    {
        loginMessage.setFill(Paint.valueOf("red"));
        loginMessage.setText("Please fill all fields");
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> loginMessage.setText(""));
        pause.play();


    }
        else
    {

        int i = a.isInManufacturerList(m);
        if(i != -1)
        {

            manu = AccountVerification.arrayM.get(i);

            Stage stage = (Stage) sign_in.getScene().getWindow();
            //stage.setTitle("LogIn");

            Parent root4 = null;
            try {
                root4 = FXMLLoader.load(getClass().getResource("/Accessories_Details/ManufacturerForm.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root4, 1400, 700);
            stage.setScene(scene);


            for(int j = 0; j < AccountVerification.arrayM.size(); j++)
            {
                if(AccountVerification.arrayM.get(j) == manu)
                {
                    for(int k = 0; k < AccountVerification.arrayM.get(j).ite.size(); k++)
                        man.mc.tablem1.getItems().add(AccountVerification.arrayM.get(j).ite.get(k));
                    break;
                }

            }

            for(int j = 0; j < AccountVerification.arrayM.size(); j++)
            {
                if(AccountVerification.arrayM.get(j) == manu)
                {

                    man.mc.tablem2.getItems().addAll(AccountVerification.arrayM.get(j).iteOrdered);
                    man.mc.tablem3.getItems().addAll(AccountVerification.arrayM.get(j).itemAcceptReject);
                }
            }


            stage.show();


        }
        else
        {
            loginMessage.setFill(Paint.valueOf("red"));
            loginMessage.setText("Incorect username password or ID ");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> loginMessage.setText(""));
            pause.play();
        }
    }
    }


        public ManufacturerClass RetObj()
        {
            return manu;
        }

}
