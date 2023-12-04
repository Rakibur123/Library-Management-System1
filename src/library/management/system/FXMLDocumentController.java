package library.management.system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLDocumentController {

    @FXML
    private ComboBox<String> combBox;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private AnchorPane Anchorebackground1;

    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private Label Label;

    @FXML
    private Button signin;

    @FXML
    private Button close;

    public void initialize() {
        combBox.getItems().addAll("Admin", "Student");
        combBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void btnsignin(ActionEvent event) {
        String userType = combBox.getValue(); // Get the selected user type
        String enteredPassword = password.getText(); // Get the entered password

        System.out.println("User Type: " + userType);
        System.out.println("Entered Password: " + enteredPassword);

        // Check the entered password against the expected passwords for admin and student
        if ("Admin".equals(userType) && "admin".equals(enteredPassword)) {
            System.out.println("Admin login");
            openadmindashboardFXML();
        } else if ("Student".equals(userType) && "1234".equals(enteredPassword)) {
            System.out.println("Student login");
            openstudentdashboardFXML();
        } else {
            // Incorrect password, show an error message
            showAlert("Incorrect Password", "Invalid password for " + userType);
        }
    }

    private void openadmindashboardFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admindashboardFXML.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();

            // Close the current login window if needed
            Stage currentStage = (Stage) username.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openstudentdashboardFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("studentdashboardFXML.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Student Dashboard");
            stage.show();

            // Close the current login window if needed
            Stage currentStage = (Stage) username.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void btnclose(ActionEvent event) {
        // Handle close button action if needed
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handlepassword(ActionEvent event) {
        // Handle password field action if needed
        System.out.println("Password field action");
    }
}
