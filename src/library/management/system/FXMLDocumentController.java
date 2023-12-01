package library.management.system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController {

    @FXML
    private Button adminButton;

    @FXML
    private Button studentButton;

    @FXML
    private AnchorPane background;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private void handleAdminButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLoginFXML.fxml"));
            Parent adminRoot = loader.load();
            Stage adminStage = new Stage();
            adminStage.setScene(new Scene(adminRoot));
            adminStage.setTitle("AdminLoginFXML");
            adminStage.show();

            // Close the current window if needed
            Stage currentStage = (Stage) adminButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    @FXML
    private void handleStudentButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentLoginFXML.fxml"));
            Parent studentRoot = loader.load();
            Stage studentStage = new Stage();
            studentStage.setScene(new Scene(studentRoot));
            studentStage.setTitle("StudentLoginFXML");
            studentStage.show();

            // Close the current window if needed
            Stage currentStage = (Stage) studentButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
