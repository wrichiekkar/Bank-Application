/*
 * Wrichiek Kar
 * 500830125
 * COE528
 */
package bankapplication;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author karwr
 */
public class AddCustomerController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Password;
    @FXML
    private Label Error;
    @FXML
    private Button BackButton;
    @FXML
    private Button AddCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Name(ActionEvent event) {
    }

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        //Go back to manager options page
        Parent ManagerOptions_root = FXMLLoader.load(getClass().getResource("ManagerOptions.fxml"));
        Scene ManagerOptions_Scene = new Scene(ManagerOptions_root);
        Stage ManagerOptions_Scene1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ManagerOptions_Scene1.setScene(ManagerOptions_Scene);
    }

    @FXML
    private void AddCustomer(ActionEvent event) {
        String fileName = Name.getText().toLowerCase() + ".txt";
        File file = new File(fileName);
        //check if name field is empty
        if (Name.getText().toLowerCase().isEmpty()) {
            Error.setText("Please enter a valid name");
            return;
        }
        //Check if password field is empty
        if (Password.getText().isEmpty()) {
            Error.setText("Please enter a valid password");
            return;
        }
        //Check if customer file already exists
        if (file.exists()) {
            Error.setText("Customer with that username already exists");
            return;
        } else {
            try {
                //Create customer file
                PrintWriter writer = new PrintWriter(file, "UTF-8");
                Error.setText(Name.getText()+" has been created");
                writer.println(Password.getText());
                writer.println(100.00);
                writer.println("silver");
                writer.close();
                Name.clear();
                Password.clear();
            } catch (Exception e) {
                System.out.print(e);
            }
        }
    }

    @FXML
    private void Password(ActionEvent event) {
    }

    @FXML
    private void Error(MouseEvent event) {
    }

}
