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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author karwr
 */
public class ManagerOptionsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddCustomerButton(ActionEvent event) throws IOException {
        //Go to Add customer option
        Parent AddCustomer_root = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
        Scene AddCustomer_Scene = new Scene(AddCustomer_root);
        Stage AddCustomer_Scene1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AddCustomer_Scene1.setScene(AddCustomer_Scene);
    }

    @FXML
    private void DeleteCustomerButton(ActionEvent event) throws IOException {
        //Go to Delete customer option
        Parent DeleteCustomer_root = FXMLLoader.load(getClass().getResource("DeleteCustomer.fxml"));
        Scene DeleteCustomer_Scene = new Scene(DeleteCustomer_root);
        Stage DeleteCustomer_Scene1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DeleteCustomer_Scene1.setScene(DeleteCustomer_Scene);
    }

    @FXML
    private void LogoutButton(ActionEvent event) throws IOException {
        //Log out and go back to login page
        Parent Login_root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene Login_Scene = new Scene(Login_root);
        Stage Login_Scene1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Login_Scene1.setScene(Login_Scene);
    }

}
