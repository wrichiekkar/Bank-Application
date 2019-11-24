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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author karwr
 */
public class DepositPageController implements Initializable {

    @FXML
    private TextField DepositField;
    @FXML
    private Button DepositButton;
    @FXML
    private Button BackButton;
    @FXML
    private Label Error;
    @FXML
    private Label FinalStatement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public String getUsername;

    //Get username from login page
    public void getUser(String input) {
        getUsername = input;
    }

    @FXML
    private void DepositField(ActionEvent event) {
    }

    @FXML
    private void DepositButton(ActionEvent event) {
        String Deposit = DepositField.getText();
        if (Deposit.isEmpty()) {
            Error.setText("Please enter a valid amount");
            //Regex \\d+\\.\\d{1,2} d+ = multiple digits, /./ = check for ".", d{1,2} check for 1-2 digits after .
        } else if (Deposit.matches("\\d+\\.\\d{1,2}")) {
            //Convert string to double
            double amount = Double.parseDouble(Deposit);
            Customer customer = new Customer(getUsername);
            //Set new balance
            customer.setBalance(customer.getBalance() + amount);
            //Update file including balance and tier
            customer.updateFile(getUsername);
            Error.setText("$" + amount + " has been deposited to your account");
            FinalStatement.setText("Your new balance is: $" + customer.getBalance());
        } else {
            Error.setText("Please enter a valid amount, Ex: 1000.00");
        }
    }

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        //Go back to customer options and send username back to save login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerOptions.fxml"));
        Parent root = (Parent) loader.load();
        CustomerOptionsController secondController = loader.getController();
        secondController.getUser(getUsername);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
