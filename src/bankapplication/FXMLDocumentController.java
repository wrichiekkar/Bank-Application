/*
 * Wrichiek Kar
 * 500830125
 * COE528
 */
package bankapplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author karwr
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button LogInButton;
    @FXML
    private Label label;
    @FXML
    private TextField textUsername;
    @FXML
    private PasswordField textPassword;
    @FXML
    private Label ErrorLabel;
    @FXML
    private ChoiceBox choicebox1;
    ObservableList<String> choicebox = FXCollections.observableArrayList("Manager", "Customer");

    @FXML
    private void LogInButton(ActionEvent event) throws IOException {
        String Username = textUsername.getText();
        String Password = textPassword.getText();
        String fileName = Username.toLowerCase() + ".txt";
        //get role option
        String role = (String) choicebox1.getValue();
        File file = new File(fileName);
        //Check if any field is empty 
        if (Username.isEmpty() || Password.isEmpty()) {
            ErrorLabel.setText("Please enter a valid username and password");
        }
        //Check if manager, if manager open ManagerOptions
        if (Username.toLowerCase().equals("admin") && Password.equals("admin") && role.equals("Manager")) {
            Parent ManagerOptions_root = FXMLLoader.load(getClass().getResource("ManagerOptions.fxml"));
            Scene ManagerOptions_Scene = new Scene(ManagerOptions_root);
            Stage ManagerOptions_Scene1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ManagerOptions_Scene1.setScene(ManagerOptions_Scene);
            //Check if customer file exists
        } else if (file.exists() || file.isDirectory()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String password = reader.readLine();
            //validate password
            if (password.equals(Password) && role.equals("Customer")) {
                //Open Customer options and send username
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerOptions.fxml"));
                Parent root = (Parent) loader.load();
                CustomerOptionsController secondController = loader.getController();
                secondController.getUser(Username);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            } else {
                ErrorLabel.setText("Invalid login, try again");
            }
        } else {
            ErrorLabel.setText("Account does not exists");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choicebox1.setItems(choicebox);

    }

}
