package Accessories_Details_Controllers;

import Login.controllers.AccountVerification;
import Login.controllers.Customer;
import Login.controllers.Manufacturer;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManufacturerController implements Initializable {

    AddItem ai = new AddItem();
    Manufacturer M;
    public static ManufacturerController mc;

    @FXML
    public Button deleteButon;

    @FXML
    public TextField textfield_search_by_id;

    @FXML
    public Button exitButon;

    @FXML
    public Button search_by_id;

    @FXML
    public Text message_text;

    @FXML
    public TableView<Item> tablem1;

    @FXML
    public TableColumn<Item, String > Column_Acc_ID;

    @FXML
    public TableColumn<Item, String> Column_AccName;

    @FXML
    public TableColumn<Item, String> Column_Category;

    @FXML
    private TableColumn<Item, String> Column_Price;

    @FXML
    public TableColumn<Item, String> Column_Price_range;

    @FXML
    public TableColumn<Item, String > Column_Quality;


    @FXML
    public TextField add_item_Acc_ID;

    @FXML
    public TextField add_item_Acc_name;

    @FXML
    public TextField add_item_Price;

    @FXML
    public CheckBox add_item_low;

    @FXML
    public CheckBox add_item_medium;

    @FXML
    public CheckBox add_item_high;

    @FXML
    public ChoiceBox<String> add_item_CH_Box_Category;

    @FXML
    public ChoiceBox<String> add_item_CH_Box_Quality;

    @FXML
    public Button add_item_addButton;

    @FXML
    public Button acceptOrder;

    @FXML
    public Button rejectOrder;

    @FXML
    public TableView<Item> tablem2;

    @FXML
    public TableColumn<Item, String> Acc_ID_2;

    @FXML
    public TableColumn<Item, String> Acc_name_2;

    @FXML
    public TableColumn<Item, String> Category_2;

    @FXML
    public TableColumn<Item, String> Price_2;

    @FXML
    public TableColumn<Item, String> Price_range_2;

    @FXML
    public TableColumn<Item, String> Quality_2;

    @FXML
    public TableColumn<Item, String> Quantity_2;

    @FXML
    public TableView<Item> tablem3;

    @FXML
    public TableColumn<Item, String> Acc_ID_3;

    @FXML
    public TableColumn<Item, String> Acc_name_3;

    @FXML
    public TableColumn<Item, String> Category_3;

    @FXML
    public TableColumn<Item, String> Price_3;

    @FXML
    public TableColumn<Item, String> Price_range_3;

    @FXML
    public TableColumn<Item, String> Quality_3;

    @FXML
    public TableColumn<Item, String> Quantity_3;

    @FXML
    public TableColumn<Item, Text> Status_3;

    @FXML
    public Text add_item_message_text;

    @FXML
    public Text messageText2;

    @FXML
    public Button edit_button;


   

    
    @FXML
    void DeleteButon(ActionEvent event) {

        if(tablem1.getSelectionModel().getSelectedItem() != null)
        {
            message_text.setFill(Paint.valueOf("green"));
            message_text.setText("Successfully deleted");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> message_text.setText(""));
            pause.play();

            M = new Manufacturer();
            M.RetObj().ite.removeAll(tablem1.getSelectionModel().getSelectedItems());

            //ai.deleteFromArray(tablem1.getSelectionModel().getSelectedItem());
            tablem1.getItems().removeAll(tablem1.getSelectionModel().getSelectedItems());
        }
       else
        {
            message_text.setFill(Paint.valueOf("red"));
            message_text.setText("Please select an item");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> message_text.setText(""));
            pause.play();

        }

    }

    @FXML
    void ExitButon(ActionEvent event) {
        Stage stage = (Stage) exitButon.getScene().getWindow();
        //stage.setTitle("LogIn");

        Parent root4 = null;
        try {
            root4 = FXMLLoader.load(getClass().getResource("/Log In/Manufacturer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root4, 1200, 700);
        stage.setScene(scene);
        stage.show();

    }

    

    @FXML
    void Search_by_id(ActionEvent event) {


        if(textfield_search_by_id.getText() == null || textfield_search_by_id.getText().isEmpty())
        {
            message_text.setFill(Paint.valueOf("red"));
            message_text.setText("Please enter an ID");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> message_text.setText(""));
            pause.play();
        }
        else
        {
            M = new Manufacturer();


            Object i1 = M.RetObj().searchForItembyID(textfield_search_by_id.getText());
            if(i1 instanceof Item && i1 != null)
            {
                message_text.setFill(Paint.valueOf("green"));
                message_text.setText("Item found");
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> message_text.setText(""));
                pause.play();
               tablem1.getSelectionModel().select((Item) i1);
            }
            else
            {
                message_text.setFill(Paint.valueOf("red"));
                message_text.setText("Does not exist");
                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                pause.setOnFinished(e -> message_text.setText(""));
                pause.play();
            }
        }

    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ObservableList<String> l= FXCollections.observableArrayList();
        l.add("Media");
        l.add("Ambience");
        l.add("Interior");
        l.add("Comfort");
        add_item_CH_Box_Category.getItems().addAll(l);
        add_item_CH_Box_Quality.getItems().add("New");
        add_item_CH_Box_Quality.getItems().add("Second hand");

        tablem1.setEditable(true);
        tablem1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        Column_Acc_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Column_AccName.setCellValueFactory(new PropertyValueFactory<>("name"));
        Column_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        Column_Price_range.setCellValueFactory(new PropertyValueFactory<>("price_range"));
        Column_Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
        Column_Quality.setCellValueFactory(new PropertyValueFactory<>("Quality"));

        Acc_ID_2.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Acc_name_2.setCellValueFactory(new PropertyValueFactory<>("name"));
        Price_2.setCellValueFactory(new PropertyValueFactory<>("price"));
        Price_range_2.setCellValueFactory(new PropertyValueFactory<>("price_range"));
        Category_2.setCellValueFactory(new PropertyValueFactory<>("Category"));
        Quality_2.setCellValueFactory(new PropertyValueFactory<>("Quality"));
        Quantity_2.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        Acc_ID_3.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Acc_name_3.setCellValueFactory(new PropertyValueFactory<>("name"));
        Price_3.setCellValueFactory(new PropertyValueFactory<>("price"));
        Price_range_3.setCellValueFactory(new PropertyValueFactory<>("price_range"));
        Category_3.setCellValueFactory(new PropertyValueFactory<>("Category"));
        Quality_3.setCellValueFactory(new PropertyValueFactory<>("Quality"));
        Quantity_3.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Status_3.setCellValueFactory(new PropertyValueFactory<>("Status"));

        tablem1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                ObservableList<String> l1= FXCollections.observableArrayList();
                l1.add("low");
                l1.add("medium");
                l1.add("high");


                if(tablem1.getSelectionModel().getSelectedItem() != null)
                {
                    Column_Acc_ID.setCellFactory(TextFieldTableCell.forTableColumn());
                    Column_Acc_ID.setOnEditCommit(e->{

                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setID(e.getNewValue());
                        M.RetObj().ite.get(e.getTablePosition().getRow()).setID(e.getNewValue());

                    });


                    Column_AccName.setCellFactory(TextFieldTableCell.forTableColumn());
                    Column_AccName.setOnEditCommit(e->{

                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
                        M.RetObj().ite.get(e.getTablePosition().getRow()).setName(e.getNewValue());

                    });

                    Column_Price.setCellFactory(TextFieldTableCell.forTableColumn());
                    Column_Price.setOnEditCommit(e->{

                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrice(e.getNewValue());
                        M.RetObj().ite.get(e.getTablePosition().getRow()).setPrice(e.getNewValue());

                    });

                    Column_Price_range.setCellFactory(ChoiceBoxTableCell.forTableColumn(l1));
                    Column_Price_range.setOnEditCommit(e->{

                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrice_range(e.getNewValue());
                        M.RetObj().ite.get(e.getTablePosition().getRow()).setPrice_range(e.getNewValue());

                    });

                    Column_Category.setCellFactory(ChoiceBoxTableCell.forTableColumn(add_item_CH_Box_Category.getItems()));
                    Column_Category.setOnEditCommit(e->{

                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setCategory(e.getNewValue());
                        M.RetObj().ite.get(e.getTablePosition().getRow()).setCategory(e.getNewValue());

                    });

                    Column_Quality.setCellFactory(ChoiceBoxTableCell.forTableColumn(add_item_CH_Box_Quality.getItems()));
                    Column_Quality.setOnEditCommit(e->{

                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setQuality(e.getNewValue());
                        M.RetObj().ite.get(e.getTablePosition().getRow()).setQuality(e.getNewValue());

                    });

                }
            }
        });

        mc = this;

    }

    public void mouseClicked(MouseEvent mouseEvent) {

        this.tablem1.getSelectionModel().clearSelection();

    }

   /* public ManufacturerController RETObj()
    {
        return mc;
    }*/

}
