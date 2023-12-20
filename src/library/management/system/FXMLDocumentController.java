package library.management.system;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane Anchorebackground1;
    @FXML
    private AnchorPane Anchorpane;
    @FXML
    private Button close;
    @FXML
    private Button lognin;
    @FXML
    private FontAwesomeIconView users;
    @FXML
    private Button minimize;
    @FXML
    private PasswordField Password;
    @FXML
    private TextField studeNumer;
    @FXML
    private Label Label;
    @FXML
    private ComboBox<String> combobox;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox.setItems(FXCollections.observableArrayList("Admin", "Student"));
    }

    @FXML
    private void btnlognin(ActionEvent event) {
        String studentSql = "SELECT * FROM student WHERE studentNumber = ? AND password = ?";
        String adminSql = "SELECT * FROM admin WHERE adminNumber = ? AND password = ?";

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/librarydatabase", "root", "");

            prepare = connect.prepareStatement(combobox.getValue().equals("Student") ? studentSql : adminSql);
            prepare.setString(1, studeNumer.getText());
            prepare.setString(2, Password.getText());
            result = prepare.executeQuery();

            if (studeNumer.getText().isEmpty() || Password.getText().isEmpty()) {
                // Show an alert for empty fields
                showAlert("Error", "Please enter both student/admin number and password.");
            } else {
                // Check login credentials
                if (result.next()) {
                    // Login successful, open dashboard based on the selected role
                    String selectedRole = combobox.getValue();
                    openDashboard(selectedRole);
                } else {
                    // Invalid credentials, show an error message
                    showAlert("Error", "Invalid credentials. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            closeResources();
        }
    }

    private void password(KeyEvent event) {
        if (!event.getCharacter().matches("[\\d]")) {
            event.consume();
            studeNumer.setStyle("-fx-border-color:#e04040");
        } else {
            studeNumer.setStyle("-fx-border-color:#fff");
        }
    }

   @FXML
private void btnclose(ActionEvent event) {
    // Get the reference to the current stage
    Stage stage = (Stage) close.getScene().getWindow();

    // Close the current stage
    stage.close();
}

@FXML
private void btnminimize(ActionEvent event) {
    // Get the reference to the current stage
    Stage stage = (Stage) minimize.getScene().getWindow();

    // Minimize the current stage
    stage.setIconified(true);
}

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void closeResources() {
        try {
            if (result != null) {
                result.close();
            }
            if (prepare != null) {
                prepare.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void openDashboard(String role) {
        String dashboardFXML;
        if ("Student".equals(role)) {
            dashboardFXML = "StudentDashboard.fxml";
        } else if ("Admin".equals(role)) {
            dashboardFXML = "AdminDashboard.fxml";
        } else {
            showAlert("Error", "Invalid role selected.");
            return;
        }

        try {
            // Load the corresponding dashboard FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(dashboardFXML));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Get the current stage and set the new scene
            Stage stage = (Stage) lognin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
