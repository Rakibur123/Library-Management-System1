
package library.management.system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Rakibur Rahman
 */
public class StudentloginFXMLController implements Initializable {

    @FXML
    private AnchorPane studentlogin;

    @FXML
    private Text studentPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void stdPassword(MouseEvent event) {
        System.out.println("Student password entered!");
        // Add your student login logic here
        // For example, you can check the entered password against the stored password
        // and navigate to the student dashboard if the login is successful.
    }
}
