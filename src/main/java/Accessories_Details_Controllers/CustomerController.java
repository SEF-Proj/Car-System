package Accessories_Details_Controllers;

import Login.controllers.AccountVerification;
import Login.controllers.Customer;
import Login.controllers.Manufacturer;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CustomerController implements Initializable {

    Customer CU;
    public static CustomerController C;
    Manufacturer manuf;


    @FXML
    public TableView<Item> table1;

    @FXML
    private TableColumn<Item, String> Acc_ID1;

    @FXML
    private TableColumn<Item, String> Acc_Name1;

    @FXML
    private TableColumn<Item, String> Category1;

    @FXML
    private TableColumn<Item, String> Price1;

    @FXML
    private TableColumn<Item, String> Price_range1;

    @FXML
    private TableColumn<Item, String> Quality1;


    @FXML
    public Button search_by_category;

    @FXML
    public Button search_price;

    @FXML
    public ChoiceBox<String> ChoiceBox_ByCategory;

    @FXML
    public TextField pret;


    @FXML
    public Button exitButton;

    @FXML
    public Button add_to_cart;

    @FXML
    public Button make_order;

    @FXML
    public Text messageText;

    @FXML
    public Text messageText1;

    @FXML
    public TableView<Item> table2;

    @FXML
    private ChoiceBox<String> ChoiceBox_ByQuantity;

    @FXML
    private TableColumn<Item, String> Acc_ID2;

    @FXML
    private TableColumn<Item, String> Acc_Name2;

    @FXML
    private TableColumn<Item, String> Category2;

    @FXML
    private TableColumn<Item, String> Price2;

    @FXML
    private TableColumn<Item, String> Price_range2;

    @FXML
    private TableColumn<Item, String> Quality2;

    @FXML
    public TableView<Item> table3;


    @FXML
    public TableColumn<Item, String> Acc_ID3;

    @FXML
    public TableColumn<Item, String> Acc_Name3;

    @FXML
    public TableColumn<Item, String> Category3;

    @FXML
    public TableColumn<Item, String> Price3;

    @FXML
    public TableColumn<Item, String> Price_range3;

    @FXML
    public TableColumn<Item, String> Quality3;

    @FXML
    public TableColumn<Item, String> Quantity3;

    @FXML
    public TableColumn<Item, Text> Status3;

    @FXML
    void Add_to_cart(ActionEvent event) {

        CU = new Customer();
        manuf = new Manufacturer();


        if(table1.getSelectionModel().getSelectedItem() != null)
        {



           // if(!CU.RetObj().itemc.contains(table1.getSelectionModel().getSelectedItem()))
            if(CU.RetObj().Contain(table1.getSelectionModel().getSelectedItems()))
            {
                table2.getItems().addAll(table1.getSelectionModel().getSelectedItems());
                CU.RetObj().itemc.addAll(table1.getSelectionModel().getSelectedItems());

                messageText1.setFill(Paint.valueOf("green"));
                messageText1.setText("successfully added");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> messageText1.setText(""));
                pause.play();


            }
            else
            {
                messageText1.setFill(Paint.valueOf("red"));
                messageText1.setText("some of selected items already stored");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> messageText1.setText(""));
                pause.play();
            }

        }
        else
        {
            messageText1.setFill(Paint.valueOf("red"));
            messageText1.setText("please select an item");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> messageText1.setText(""));
            pause.play();
        }

    }

    @FXML
    void MouseClick(MouseEvent event) {

        this.table1.getSelectionModel().clearSelection();
    }

    @FXML
    void ExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        //stage.setTitle("LogIn");

        Parent root4 = null;
        try {
            root4 = FXMLLoader.load(getClass().getResource("/Log In/Customer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root4, 1200, 700);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void MakeOrder(ActionEvent event) {

        if(ChoiceBox_ByQuantity.getValue() == null || ChoiceBox_ByQuantity.getValue().isEmpty())
        {
            messageText.setFill(Paint.valueOf("red"));
            messageText.setText("please choose quantity");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> messageText.setText(""));
            pause.play();
        }
        else
        if(table2.getSelectionModel().getSelectedItem() != null)
        {
            CU = new Customer();


            String ID = table2.getSelectionModel().getSelectedItem().getID();
            String name = table2.getSelectionModel().getSelectedItem().getName();
            String price = table2.getSelectionModel().getSelectedItem().getPrice();
            String price_range = table2.getSelectionModel().getSelectedItem().getPrice_range();
            String Category = table2.getSelectionModel().getSelectedItem().getCategory();
            String Quality = table2.getSelectionModel().getSelectedItem().getQuality();
            String Quantity = ChoiceBox_ByQuantity.getValue();
            Text Status =new Text("submitted");

            Item it = new Item(ID, name, price, price_range,Category, Quality,Quantity, Status);

            for(int i = 0; i < AccountVerification.arrayM.size(); i++)
            {
                for(int j = 0; j < AccountVerification.arrayM.get(i).ite.size(); j++)
                {
                    if(table2.getSelectionModel().getSelectedItem().equals(AccountVerification.arrayM.get(i).ite.get(j)))
                    {
                        AccountVerification.arrayM.get(i).iteOrdered.add(it);
                    }
                }
            }




            if(!CU.RetObj().AddITEM(it))
            {
                table3.getItems().add(it);
                CU.RetObj().itemOrdered.add(it);
                CU.RetObj().itemc.remove(table2.getSelectionModel().getSelectedItem());
                table2.getItems().remove(table2.getSelectionModel().getSelectedItem());
                ChoiceBox_ByQuantity.setValue("");

            }




        }
        else
        {
            messageText.setFill(Paint.valueOf("red"));
            messageText.setText("please select an item");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> messageText.setText(""));
            pause.play();
        }

    }

    @FXML
    void Search_by_category(ActionEvent event) {

        this.table1.getSelectionModel().clearSelection();
        if(ChoiceBox_ByCategory.getValue() == null || ChoiceBox_ByCategory.getValue().isEmpty())
        {
            messageText1.setFill(Paint.valueOf("red"));
            messageText1.setText("Please enter a category");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> messageText1.setText(""));
            pause.play();
        }
        else
        {
            CU = new Customer();
            int ok = 0;

            int k1 = 0;
            table1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            for(int j = 0; j < AccountVerification.arrayM.size(); j++)
                for(int k = 0; k < AccountVerification.arrayM.get(j).ite.size(); k++){
            Object i1 = CU.RetObj().searchForItembyCategory(ChoiceBox_ByCategory.getValue(), j, k);
            if(i1 instanceof Item && i1 != null)
            {
                k1++;
                table1.getSelectionModel().select((Item) i1);
                ok = 1;
            }

            }
            if(ok == 0)
            {
                messageText1.setFill(Paint.valueOf("red"));
                messageText1.setText("not found");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> messageText1.setText(""));
                pause.play();
            }
            else
            {
                messageText1.setFill(Paint.valueOf("green"));
                if(k1 > 1)
                    messageText1.setText(k1 + " items found");
                else
                    messageText1.setText(k1 + " item found");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> messageText1.setText(""));
                pause.play();
            }
        }

    }

    @FXML
    void Search_price(ActionEvent event) {

        this.table1.getSelectionModel().clearSelection();
        if(pret.getText() == null || pret.getText().isEmpty())
        {
            messageText1.setFill(Paint.valueOf("red"));
            messageText1.setText("please enter the price");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> messageText1.setText(""));
            pause.play();
        }
        else
        {
            CU = new Customer();
            int ok = 0;

            int k1 = 0;
            table1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            for(int j = 0; j < AccountVerification.arrayM.size(); j++)
                for(int k = 0; k < AccountVerification.arrayM.get(j).ite.size(); k++){
                    Object i1 = CU.RetObj().searchForItembyPrice(pret.getText(), j, k);
                    if(i1 instanceof Item && i1 != null)
                    {
                        k1++;
                        table1.getSelectionModel().select((Item) i1);
                        ok = 1;
                    }

                }
            if(ok == 0)
            {
                messageText1.setFill(Paint.valueOf("red"));
                messageText1.setText("not found");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> messageText1.setText(""));
                pause.play();
            }
            else
            {
                messageText1.setFill(Paint.valueOf("green"));
                if(k1 > 1)
                    messageText1.setText(k1 + " items found");
                else
                    messageText1.setText(k1 + " item found");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> messageText1.setText(""));
                pause.play();
            }
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> l= FXCollections.observableArrayList();
        l.add("Media");
        l.add("Ambience");
        l.add("Interior");
        l.add("Comfort");


        ObservableList<String> l1= FXCollections.observableArrayList();
        l1.add("1");
        l1.add("2");
        l1.add("3");
        l1.add("4");
        l1.add("5");

        table1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ChoiceBox_ByCategory.getItems().addAll(l);
        ChoiceBox_ByQuantity.getItems().addAll(l1);

        Acc_ID1.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Acc_Name1.setCellValueFactory(new PropertyValueFactory<>("name"));
        Price1.setCellValueFactory(new PropertyValueFactory<>("price"));
        Price_range1.setCellValueFactory(new PropertyValueFactory<>("price_range"));
        Category1.setCellValueFactory(new PropertyValueFactory<>("Category"));
        Quality1.setCellValueFactory(new PropertyValueFactory<>("Quality"));

        Acc_ID2.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Acc_Name2.setCellValueFactory(new PropertyValueFactory<>("name"));
        Price2.setCellValueFactory(new PropertyValueFactory<>("price"));
        Price_range2.setCellValueFactory(new PropertyValueFactory<>("price_range"));
        Category2.setCellValueFactory(new PropertyValueFactory<>("Category"));
        Quality2.setCellValueFactory(new PropertyValueFactory<>("Quality"));

        Acc_ID3.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Acc_Name3.setCellValueFactory(new PropertyValueFactory<>("name"));
        Price3.setCellValueFactory(new PropertyValueFactory<>("price"));
        Price_range3.setCellValueFactory(new PropertyValueFactory<>("price_range"));
        Category3.setCellValueFactory(new PropertyValueFactory<>("Category"));
        Quality3.setCellValueFactory(new PropertyValueFactory<>("Quality"));
        Quantity3.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Status3.setCellValueFactory(new PropertyValueFactory<>("Status"));
        C = this;

    }

    public void DeleteItemFromCart(ActionEvent event) {

        if(table2.getSelectionModel().getSelectedItem() != null)
        {
            messageText.setFill(Paint.valueOf("green"));
            messageText.setText("deleted successfully");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> messageText.setText(""));
            pause.play();
            CU = new Customer();
            CU.RetObj().itemc.remove(table2.getSelectionModel().getSelectedItem());
            table2.getItems().remove(table2.getSelectionModel().getSelectedItem());
        }
        else
        {
            messageText.setFill(Paint.valueOf("red"));
            messageText.setText("please select an item");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> messageText.setText(""));
            pause.play();
        }

    }

    /*public CustomerController RETOBJ()
    {
        return C;
    }*/

}
