
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Ozlympic extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Ozlympic.fxml"));
        primaryStage.setTitle("Ozlympic");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //show the main stage, can not be commented
        launch(args);

        //From previous Assignment
        ArrayList<Participates> participates=new ArrayList<>();

        participates.add(new Swimmer("1001","Nicolas",39,"ACT"));
        participates.add(new Cyclist("1002","Leonardo",33,"ACT"));
        participates.add(new Sprinter("1003","Emily",33,"ACT"));
        participates.add(new superAthlete("1004","Alex",34,"ACT"));
        participates.add(new Swimmer("2001","Jodie",28,"VIC"));
        participates.add(new Cyclist("2002","Natalie",29,"VIC"));
        participates.add(new Sprinter("2003","Seb",24,"VIC"));
        participates.add(new superAthlete("2004","Alice",27,"VIC"));
        participates.add(new Swimmer("3001","Audrey",27,"NSW"));
        participates.add(new Cyclist("3002","Cathy",26,"NSW"));
        participates.add(new Sprinter("3003","Johnson",28,"NSW"));
        participates.add(new superAthlete("3004","Julia",30,"NSW"));
        participates.add(new Swimmer("4001","Lucas",29,"TAS"));
        participates.add(new Cyclist("4002","Mandy",29,"TAS"));
        participates.add(new Sprinter("4003","David",32,"TAS"));
        participates.add(new superAthlete("4004","Vincent",23,"TAS"));
        participates.add(new Swimmer("5001","Evan",21,"WA"));
        participates.add(new Cyclist("5002","Amanda",21,"WA"));
        participates.add(new Sprinter("5003","Nancy",31,"WA"));
        participates.add(new superAthlete("5004","Pierce",25,"WA"));
        participates.add(new Swimmer("6001","Tony",21,"SA"));
        participates.add(new Cyclist("6002","Joseph",25,"SA"));
        participates.add(new Sprinter("6003","Janet",34,"SA"));
        participates.add(new superAthlete("6004","Tom",29,"SA"));
        participates.add(new Swimmer("7001","Bosco",27,"NT"));
        participates.add(new Cyclist("7002","Caity",22,"NT"));
        participates.add(new Sprinter("7003","Willa",33,"NT"));
        participates.add(new superAthlete("7004","Betty",27,"NT"));

        //official member
        participates.add(new Official("S001","Glenn",27,"VIC"));
        participates.add(new Official("S002","Ron",22,"NT"));
        participates.add(new Official("S003","Paul",33,"NSW"));
        participates.add(new Official("S004","Roy",27,"ACT"));


        Driver driver = new Driver(participates);

/*        try {
            driver.mainMenu();
        } catch (selectOptionException e) {
            e.printStackTrace();
        }*/

    }

    //From previous assignment

}

