package library.management.system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML
    private AnchorPane Anchorebackground1;
    @FXML
    private AnchorPane Anchorpane;
    @FXML
    private Label Label;
    @FXML
    private ComboBox<String> combBox;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button signin;
    @FXML
    private Button close;

    public void initialize() {
        // Initialize the ComboBox items
        combBox.getItems().addAll("Admin", "Student");
        combBox.getSelectionModel().selectFirst(); // Set default selection
    }

    @FXML
    private void handlepassword(ActionEvent event) {
        // Handle password field action if needed
    }

    @FXML
    private void btnsignin(ActionEvent event) {
        // Handle sign-in button action
        String userType = combBox.getValue(); // Get the selected user type

        if ("Admin".equals(userType)) {
            // Code for admin login
            System.out.println("Admin login");
        } else if ("Student".equals(userType)) {
            // Code for student login
            System.out.println("Student login");
        }
    }

    @FXML
    private void btnclose(ActionEvent event) {
        // Handle close button action if needed
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
