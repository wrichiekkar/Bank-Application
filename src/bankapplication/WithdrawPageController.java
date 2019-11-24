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
public class WithdrawPageController implements Initializable {

    @FXML
    private TextField WithdrawField;
    @FXML
    private Button WithdrawButton;
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
    private void WithdrawField(ActionEvent event) {
    }

    @FXML
    private void WithdrawButton(ActionEvent event) {
        String withdraw = WithdrawField.getText();
        if (withdraw.isEmpty()) {
            Error.setText("Please enter a valid amount");
          //Regex \\d+\\.\\d{1,2} d+ = multiple digits, /./ = check for ".", d{1,2} check for 1-2 digits after .
        } else if (withdraw.matches("\\d+\\.\\d{1,2}")) {
            // convert string to double
            double amount = Double.parseDouble(withdraw);
            Customer customer = new Customer(getUsername);
            if (amount > customer.getBalance()) {
                Error.setText("Insufficient funds");
            } else {
                customer.setBalance(customer.getBalance() - amount);
                customer.updateFile(getUsername);
                Error.setText("$" + amount + " has been withdrawn from your account");
                FinalStatement.setText("Your new balance is: $" + customer.getBalance());
            }
        } else {
            Error.setText("Please enter a valid amount, Ex: 1000.00");
        }
    }

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        //Go back to Customer Options and send username to save login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerOptions.fxml"));
        Parent root = (Parent) loader.load();
        CustomerOptionsController secondController = loader.getController();
        secondController.getUser(getUsername);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
