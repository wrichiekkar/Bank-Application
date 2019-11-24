/*
 * Wrichiek Kar
 * 500830125
 * COE528
 */
package bankapplication;

import java.io.File;
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
public class DeleteCustomerController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private Button Delete;
    @FXML
    private Button Back;
    @FXML
    private Label Error;

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
    private void Delete(ActionEvent event) {
        String fileName = Name.getText().toLowerCase() + ".txt";
        File file = new File(fileName);
        //Check if field is empty
        if (Name.getText().toLowerCase().isEmpty()) {
            Error.setText("Please enter a valid username");

        }
        //check if file exists, if exists delete file
        if (file.exists() && !file.isDirectory()) {
            file.delete();
            Error.setText("Success, " + Name.getText() + " has been deleted");
            Name.clear();
        //Customer does not exist
        } else {
            Error.setText("Customer does not exist");
            Name.clear();

        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        //Go back to manager options page
        Parent ManagerOptions_root = FXMLLoader.load(getClass().getResource("ManagerOptions.fxml"));
        Scene ManagerOptions_Scene = new Scene(ManagerOptions_root);
        Stage ManagerOptions_Scene1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ManagerOptions_Scene1.setScene(ManagerOptions_Scene);
    }

}
