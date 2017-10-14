import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RunController implements Initializable{

    @FXML public CheckBox athlete1;
    @FXML public CheckBox athlete2;
    @FXML public CheckBox athlete3;
    @FXML public CheckBox athlete4;
    @FXML public CheckBox athlete5;
    @FXML public CheckBox athlete6;
    @FXML public CheckBox athlete7;
    @FXML public CheckBox athlete8;
    @FXML public CheckBox athlete9;
    @FXML public CheckBox athlete10;
    @FXML public CheckBox athlete11;
    @FXML public CheckBox athlete12;

    @FXML public Button btnExit;
    @FXML public Button btnSave;
    @FXML public Button btnStartGame;
    @FXML public Button generateAthlete;

    @FXML public  ListView runResult;
    @FXML  public AnchorPane runPane;

    //get all athletes attend the game
    ArrayList<Participates> participates=readTXTData.seperateData();
    public Driver driver = new Driver(participates);
    Participates referee; // to store the referee

    //An array List to store the athlete attend the swim game
    private ArrayList<Participates> pAttendRun = new ArrayList<>();

    //Array list to store the athletes after player selected from checkboxes
    private ArrayList<Participates> pAttendRun_S = new ArrayList<>();

    //Array list to store the athletes after sorted
    private ArrayList<Participates> pAttendRun_Sorted = new ArrayList<>();

    public int GAME_TIMES =0;


    public RunController() throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        driver.setType("running");
        generateAthlete.setDisable(false);
        btnStartGame.setDisable(true);
        btnSave.setDisable(true);
    }

    @FXML private void btnExitAction(){
        System.out.println("Exit button pressed!");
        Platform.exit();
    }

    @FXML private void btnSaveAction() throws IOException {

        System.out.println("Save button pressed!");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/gameResults.txt", true))) {

            if(GAME_TIMES<10){
                bw.write("Game ID : R0"+ GAME_TIMES);
                bw.newLine();
            }else{
                bw.write("Game ID : R"+ GAME_TIMES);
                bw.newLine();
            }

            bw.write("Referee: "+referee.getName());
            bw.newLine();

            for (Participates p :
                    pAttendRun_Sorted) {
                bw.write(p.getID()+" "+p.getName()+" "+p.getAge()+" "+p.getState()+"       Time: "+p.getRunningTime()+"        score: "+p.getScore());
                bw.newLine();
            }

            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();

        }

        btnSave.setDisable(true);

        Stage stage=new Stage();
        Label warning =new Label("Game Results Saved! Check gameResults.txt");
        warning.setPadding(new Insets(30));
        warning.setAlignment(Pos.CENTER);
        Scene scene=new Scene(warning,400,170);
        stage.setScene(scene);
        stage.setTitle("SAVE SUCCESS");
        stage.setResizable(false);
        stage.show();

    }

    @FXML private void btnStartGameAction(){
        GAME_TIMES++;
        pAttendRun_S.clear();
        //get all potential official members
        driver.generateOfficial();
        //get the random referee
        referee = driver.generateReferee();
        System.out.println(referee.getName());

        int numberSelected=0;
        System.out.println("Start button pressed!");
        if(athlete1.isSelected()){
            pAttendRun_S.add(pAttendRun.get(0));
            numberSelected++;
        }
        if(athlete2.isSelected()){
            pAttendRun_S.add(pAttendRun.get(1));
            numberSelected++;
        }
        if(athlete3.isSelected()){
            pAttendRun_S.add(pAttendRun.get(2));
            numberSelected++;
        }
        if(athlete4.isSelected()){
            pAttendRun_S.add(pAttendRun.get(3));
            numberSelected++;
        }
        if(athlete5.isSelected()){
            pAttendRun_S.add(pAttendRun.get(4));
            numberSelected++;
        }
        if(athlete6.isSelected()){
            pAttendRun_S.add(pAttendRun.get(5));
            numberSelected++;
        }

        if(athlete7.isSelected()){
            pAttendRun_S.add(pAttendRun.get(6));
            numberSelected++;
        }
        if(athlete8.isSelected()){
            pAttendRun_S.add(pAttendRun.get(7));
            numberSelected++;
        }
        if(athlete9.isSelected()){
            pAttendRun_S.add(pAttendRun.get(8));
            numberSelected++;
        }
        if(athlete10.isSelected()){
            pAttendRun_S.add(pAttendRun.get(9));
            numberSelected++;
        }
        if(athlete11.isSelected()){
            pAttendRun_S.add(pAttendRun.get(10));
            numberSelected++;
        }
        if(athlete12.isSelected()){
            pAttendRun_S.add(pAttendRun.get(11));
            numberSelected++;
        }

        if(numberSelected<4||numberSelected>8){

            Stage stage=new Stage();
            Label warning =new Label("Please select athletes between 4-8");
            warning.setPadding(new Insets(30));
            warning.setAlignment(Pos.CENTER);
            Scene scene=new Scene(warning,300,100);
            stage.setScene(scene);
            stage.setTitle("WARNING");
            stage.setResizable(false);
            stage.show();

        }else{
            driver.sortAthlete(pAttendRun_S);
            //pAttendSwim_Sorted.clear();
            pAttendRun_Sorted=driver.getSortedAthlete();
            ObservableList<String> items = FXCollections.observableArrayList ();

            if(GAME_TIMES<10){
                items.add("Game ID: R0"+GAME_TIMES);
            }else{
                items.add("Game ID: R"+GAME_TIMES);
            }
            items.add("Referee: "+referee.getName());
            for (Participates p :
                    pAttendRun_Sorted) {
                items.add(p.getID()+" "+p.getName()+" "+p.getAge()+" "+p.getState()+"       Time: "+p.getRunningTime()+"        score: "+p.getScore());
            }
            runResult.setItems(items);
            btnStartGame.setDisable(true);
            generateAthlete.setDisable(false);
            btnSave.setDisable(false);
        }

        System.out.println(numberSelected);

    }

    @FXML private void btnGenerateAction(){
        btnStartGame.setDisable(false);
        generateAthlete.setDisable(true);
        driver.getAttendAthlete();
        //this is the athletes who attend the game
        pAttendRun = driver.getAthlete();
        System.out.println("Generate button pressed!");
        athlete1.setText(pAttendRun.get(0).getID()+" "+ pAttendRun.get(0).getName());
        athlete2.setText(pAttendRun.get(1).getID()+" "+ pAttendRun.get(1).getName());
        athlete3.setText(pAttendRun.get(2).getID()+" "+ pAttendRun.get(2).getName());
        athlete4.setText(pAttendRun.get(3).getID()+" "+ pAttendRun.get(3).getName());
        athlete5.setText(pAttendRun.get(4).getID()+" "+ pAttendRun.get(4).getName());
        athlete6.setText(pAttendRun.get(5).getID()+" "+ pAttendRun.get(5).getName());
        athlete7.setText(pAttendRun.get(6).getID()+" "+ pAttendRun.get(6).getName());
        athlete8.setText(pAttendRun.get(7).getID()+" "+ pAttendRun.get(7).getName());
        athlete9.setText(pAttendRun.get(8).getID()+" "+ pAttendRun.get(8).getName());
        athlete10.setText(pAttendRun.get(9).getID()+" "+ pAttendRun.get(9).getName());
        athlete11.setText(pAttendRun.get(10).getID()+" "+ pAttendRun.get(10).getName());
        athlete12.setText(pAttendRun.get(11).getID()+" "+ pAttendRun.get(11).getName());

    }

    @FXML public Button showAll;
    @FXML public void btnShowAll(){
        ObservableList<String> items = FXCollections.observableArrayList ();
        for (Participates p :
                participates) {
            items.add(p.getID() + " " + p.getName() + " " + p.getAge() + " " + p.getState() + "        score: " + p.getScore());
        }
        runResult.setItems(items);

    }


}
