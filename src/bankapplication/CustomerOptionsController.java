/*
 * Wrichiek Kar
 * 500830125
 * COE528
 */
package bankapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author karwr
 */
public class CustomerOptionsController extends FXMLDocumentController implements Initializable {

    @FXML
    private Button WithdrawButton;
    @FXML
    private Button DepositButton;
    @FXML
    private Button OnlinePurchaseButton;
    @FXML
    private Button LogoutButton;
    @FXML
    private Label Header;

    public String getUsername;
    
    //Get username from login page
    public void getUser(String input) {
        getUsername = input;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void WithdrawButton(ActionEvent event) throws IOException {
        //Send username to withdraw page and open page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WithdrawPage.fxml"));
        Parent root = (Parent) loader.load();
        WithdrawPageController ThirdController = loader.getController();
        ThirdController.getUser(getUsername);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    private void DepositButton(ActionEvent event) throws IOException {
        //Send username to deposit page and open page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DepositPage.fxml"));
        Parent root = (Parent) loader.load();
        DepositPageController ThirdController = loader.getController();
        ThirdController.getUser(getUsername);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    private void OnlinePurchaseButton(ActionEvent event) throws IOException {
        //Send username to online purchase page and open page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PurchasePage.fxml"));
        Parent root = (Parent) loader.load();
        PurchasePageController ThirdController = loader.getController();
        ThirdController.getUser(getUsername);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void LogoutButton(ActionEvent event) throws IOException {
        //Open login page
        Parent Login_root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene Login_Scene = new Scene(Login_root);
        Stage Login_Scene1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Login_Scene1.setScene(Login_Scene);

    }

}
