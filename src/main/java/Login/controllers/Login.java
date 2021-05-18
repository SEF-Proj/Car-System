package Login.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

public class Login {

  @FXML
  public Text loginMessage;

  @FXML
    public Button btn_msg1;
  @FXML
  public Button btn_msg2;
  @FXML
  public Button btn_msg3;
  @FXML
  void oricum(ActionEvent event) {


    Stage stage = (Stage) btn_msg1.getScene().getWindow();
    stage.setTitle("Manufacturer");

    Parent root1 = null;
    try {
      root1 = FXMLLoader.load(getClass().getResource("/Log In/Manufacturer.fxml"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Scene scene = new Scene(root1, 1200, 700);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  void customer(ActionEvent event) {

    Stage stage = (Stage) btn_msg2.getScene().getWindow();
    stage.setTitle("Customer");

    Parent root2 = null;
    try {
      root2 = FXMLLoader.load(getClass().getResource("/Log In/Customer.fxml"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    Scene scene = new Scene(root2, 1200, 700);
    stage.setScene(scene);

    stage.show();



  }



}
