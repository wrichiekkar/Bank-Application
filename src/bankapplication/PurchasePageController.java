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
public class PurchasePageController implements Initializable {

    @FXML
    private TextField PurchaseField;
    @FXML
    private Button PurchaseButton;
    @FXML
    private Button BackButton;
    @FXML
    private Label FinalStatement;
    @FXML
    private Label Error;

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
    private void PurchaseButton(ActionEvent event) {
        String purchase = PurchaseField.getText();
        if (purchase.isEmpty()) {
            Error.setText("Please enter a valid purchase");
          //Regex \\d+\\.\\d{1,2} d+ = multiple digits, /./ = check for ".", d{1,2} check for 1-2 digits after .
        } else if (purchase.matches("\\d+\\.\\d{1,2}")) {
            double amount = Double.parseDouble(purchase);
            Customer customer = new Customer(getUsername);
            //Minimum purchase is $50
            if (amount < 50) {
                Error.setText("Purchase must be at least $50.00");
            } else if (amount > customer.getBalance()) {
                Error.setText("Insufficient funds");
            } else {
                customer.getTier();
                //Make purchase and subtract fee based on tier
                customer.setBalance(customer.getBalance() - amount - customer.getTier().getFee());
                //Update new balance and tier
                customer.updateFile(getUsername);
                Error.setText("$" + amount + " has been deducted from your account");

                FinalStatement.setText("Your new balance is: $" + customer.getBalance());
            }
        } else {
            Error.setText("Please enter a valid amount, Ex: 1000.00");
        }
    }

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        //Go back to customer options and send username to save login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerOptions.fxml"));
        Parent root = (Parent) loader.load();
        CustomerOptionsController secondController = loader.getController();
        secondController.getUser(getUsername);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
