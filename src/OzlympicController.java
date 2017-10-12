import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

public class OzlympicController implements Initializable{

    @FXML private static Tab swimTab;
    @FXML private static Tab runTab;
    @FXML private static Tab cycleTab;

    @FXML private void swimSelected(){
            System.out.println("swim Tab selected!");
    }

    @FXML private void runSelected(){
            System.out.println("run Tab selected!");
    }

    @FXML private void cycleSelected(){
            System.out.println("cycle Tab selected!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
