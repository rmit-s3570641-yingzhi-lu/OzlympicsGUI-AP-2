
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Ozlympic extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Ozlympic.fxml"));
        primaryStage.setTitle("Ozlympic");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, selectOptionException {
        //show the main stage, can not be commented
        launch(args);

        //get all athletes attend the game
        ArrayList<Participates> participates=readTXTData.seperateData();

        Driver driver = new Driver(participates);

        //driver.mainMenu();

    }

    //From previous assignment

}

