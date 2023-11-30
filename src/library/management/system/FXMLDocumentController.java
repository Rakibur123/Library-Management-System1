package library.management.system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController {

    @FXML
    private Button Admin;
    @FXML
    private Button Student;
    @FXML
    private AnchorPane background;
    @FXML
    private AnchorPane anchorpane2;

    @FXML
    private void Admin(ActionEvent event) {
        System.out.println("Admin button clicked!");
    }

    @FXML
    private void Student(ActionEvent event) {
        System.out.println("Student button clicked!");
    }
}
