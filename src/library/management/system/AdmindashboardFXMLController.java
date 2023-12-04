package library.management.system;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class AdmindashboardFXMLController implements Initializable {

    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> coltittle;
    @FXML
    private TableColumn<?, ?> colaurther;
    @FXML
    private TableColumn<?, ?> colyear;
    @FXML
    private TableColumn<?, ?> colpage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization code for Admin Dashboard
    }
}
