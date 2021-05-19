package Login.controllers;

import Accessories_Details_Controllers.CustomerController;
import Accessories_Details_Controllers.ManufacturerController;
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

public class Customer {


    SignUpCus s = new SignUpCus();
    AccountVerification ac = s.c;
    static CustomerClass cus;
    CustomerController cu = new CustomerController();


    @FXML
    public PasswordField passwordField;

    @FXML
    public TextField usernameField;

    @FXML
    public Button go_back;

    @FXML
    public Button sign_in;

    @FXML
    public Text loginMessage;

    @FXML
    public Button sign_up_c;

    @FXML
    void Sign_up_c(ActionEvent event) {

        Stage stage = (Stage) sign_up_c.getScene().getWindow();
        stage.setTitle("Customer account");

        Parent root3 = null;
        try {
            root3 = FXMLLoader.load(getClass().getResource("/Log In/makeaccountcus.fxml"));
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
        stage.setTitle("LogIn");

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
    void Sign_in(ActionEvent event) {
        CustomerClass c = new CustomerClass(usernameField.getText(), passwordField.getText());
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty())
        {
            loginMessage.setFill(Paint.valueOf("red"));
            loginMessage.setText("Please fill all fields");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> loginMessage.setText(""));
            pause.play();


        }
        else
        {
          //CustomerClass c = new CustomerClass(usernameField.getText(), passwordField.getText());
            int i = ac.isInCustomerList(c);
          if(i != -1)
          {
              cus = AccountVerification.arrayC.get(i);

              Stage stage = (Stage) sign_in.getScene().getWindow();
              //stage.setTitle("LogIn");

              Parent root4 = null;
              try {
                  root4 = FXMLLoader.load(getClass().getResource("/Accessories_Details/CustomerForm.fxml"));
              } catch (IOException e) {
                  e.printStackTrace();
              }
              Scene scene = new Scene(root4, 1200, 700);
              stage.setScene(scene);


              for(int j = 0; j < AccountVerification.arrayM.size(); j++)
              {


                      for(int k = 0; k < AccountVerification.arrayM.get(j).ite.size(); k++)
                          cu.C.table1.getItems().add(AccountVerification.arrayM.get(j).ite.get(k));


              }
              for(int j = 0; j < AccountVerification.arrayC.size(); j++)
              {
                  if(AccountVerification.arrayC.get(j) == cus)
                  {
                      cu.C.table2.getItems().addAll(AccountVerification.arrayC.get(j).itemc);
                      cu.C.table3.getItems().addAll(AccountVerification.arrayC.get(j).itemOrdered);
                  }



              }


              stage.show();



          }
          else
          {
              loginMessage.setFill(Paint.valueOf("red"));
              loginMessage.setText("Incorect username or password");
              PauseTransition pause = new PauseTransition(Duration.seconds(1));
              pause.setOnFinished(e -> loginMessage.setText(""));
              pause.play();
          }
        }
    };

    public CustomerClass RetObj()
    {
        return cus;
    }

}



