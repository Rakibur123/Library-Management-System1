package library.management.system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rakibur Rahman
 */
public class AdminloginFXMLController implements Initializable {

    @FXML
    private AnchorPane Login;

    @FXML
    private PasswordField admPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adminPassword(ActionEvent event) {
        String enteredPassword = admPassword.getText();
        // Add your admin login logic here
        // For example, you can check the entered password against the stored admin password
        // and perform actions accordingly.
        System.out.println("Admin password entered: " + enteredPassword);
    }
}
