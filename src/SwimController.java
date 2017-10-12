import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class SwimController  implements Initializable{

    @FXML public static CheckBox athlete1;
    @FXML public static CheckBox athlete2;
    @FXML public static CheckBox athlete3;
    @FXML public static CheckBox athlete4;
    @FXML public static CheckBox athlete5;
    @FXML public static CheckBox athlete6;
    @FXML public static CheckBox athlete7;
    @FXML public static CheckBox athlete8;
    @FXML public static CheckBox athlete9;
    @FXML public static CheckBox athlete10;
    @FXML public static CheckBox athlete11;
    @FXML public static CheckBox athlete12;

    @FXML public static Button btnExit;
    @FXML public static Button btnSave;
    @FXML public static Button btnStartGame;

    @FXML public static ListView swimResult;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void btnExitAction(){
        System.out.println("Exit button pressed!");
    }

    @FXML private void btnSaveAction(){
        System.out.println("Save button pressed!");
    }

    @FXML private void btnStartGameAction(){
        System.out.println("Start button pressed!");
    }

    @FXML public static Button generateAthlete;
    @FXML private void btnGenerateAction(){
        System.out.println("Generate button pressed!");
    }
}
