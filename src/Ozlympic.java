
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ozlympic extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
   /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("Ozlympic.fxml"));

        //controller
        loader.setController(new OzlympicController());

        Parent root =loader.load();*/

        Parent root = new FXMLLoader(getClass().getResource("Ozlympic.fxml")).load();

        primaryStage.setTitle("Ozlympic");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, selectOptionException {
        //show the main stage, can not be commented
        launch(args);
    }


}

