import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Driver {

    private int choice;// the choice of the menu
    private String type; //the type of the game selected
    private int athleteChoice = 0;//the choice of athlete
    private int numberOfAthlete = 0;// the number of athlete
    private int number = 1;// the number of running times

    private Participates referee;

    //athlete who attend current competition
    private ArrayList<Participates> athlete = new ArrayList<>();
    private ArrayList<Participates> sortedAthlete = new ArrayList<>();

    //store the data passed by
    private ArrayList<Participates> swimmingAttender = new ArrayList<>();
    private ArrayList<Participates> runningAttender = new ArrayList<>();
    private ArrayList<Participates> cyclistAttender = new ArrayList<>();
    private ArrayList<Participates> official = new ArrayList<>();

    //the participants of current show
    private ArrayList<Participates> allParticipates = new ArrayList<>();

    //hashset to store the game history
    private HashSet<Game> gameHistory = new HashSet<>();


    private File storedData = new File("gameResults.txt"); // create a new file
    //the operator of the file
    private BufferedWriter out = new BufferedWriter(new FileWriter(storedData));

      //out.write("S"+s[runTimes]+", ");

    /**
     * a constructor to initialize the whole data
     *
     * @param participates get from data resource
     */
    Driver(ArrayList<Participates> participates) throws IOException {
        this.allParticipates = participates;

        if (!storedData.exists()) {
            storedData.createNewFile();
            // if the fire not exists,create new one
        }
    }

    /**
     * print all athlete who attend the game
     */
    private void displayAthlete(ArrayList<Participates> athlete) {
        System.out.println();
        System.out.println("The all athletes attend this game are as below:");
/*        for (Participates attendAthlete: athlete) {
            System.out.println(attendAthlete.getID()+" "+attendAthlete.getName()+" "+attendAthlete.getAge()+" "+attendAthlete.getState());
        }*/
        for (int i = 0; i < athlete.size(); i++) {
            System.out.println(i + 1 + ":" + athlete.get(i).getID() + " " + athlete.get(i).getName() + " " + athlete.get(i).getAge() + " " + athlete.get(i).getState());
        }
    }

    /**
     * print all athlete who attend the game with times
     */
    private void displayAthleteTime(ArrayList<Participates> athlete) {
        System.out.println();
        for (Participates anAthlete : athlete) {
            System.out.println(anAthlete.getID() + " | " + anAthlete.getName() + " | " + anAthlete.getAge() + " | " + anAthlete.getState() + " | " + anAthlete.getRunningTime());
        }
    }

    /**
     * print all athlete who attend the game with times
     */
    private void displayAthleteScoreInOneGame(ArrayList<Participates> athlete) {
        System.out.println();

        System.out.println(1 + ":" + athlete.get(0).getID() + " | " + athlete.get(0).getName() + " | " + athlete.get(0).getAge() + " | " + athlete.get(0).getState() + " | " + athlete.get(0).getRunningTime() + " | 5");
        System.out.println(2 + ":" + athlete.get(1).getID() + " | " + athlete.get(1).getName() + " | " + athlete.get(1).getAge() + " | " + athlete.get(1).getState() + " | " + athlete.get(1).getRunningTime() + " | 2");
        System.out.println(3 + ":" + athlete.get(2).getID() + " | " + athlete.get(2).getName() + " | " + athlete.get(2).getAge() + " | " + athlete.get(2).getState() + " | " + athlete.get(2).getRunningTime() + " | 1");

        for (int i = 3; i < athlete.size(); i++) {
            System.out.println(i + 1 + ":" + athlete.get(i).getID() + " | " + athlete.get(i).getName() + " | " + athlete.get(i).getAge() + " | " + athlete.get(i).getState() + " | " + athlete.get(i).getRunningTime() + " | 0");

        }
    }

    /**
     * separate data to different kind
     */
    private void generateAthleteAttendSwimming() {
        swimmingAttender.clear();
        for (Participates attendAthlete : allParticipates) {
            if (attendAthlete instanceof Swimmer) {
                attendAthlete.compete();
                swimmingAttender.add(attendAthlete);
            } else if (attendAthlete instanceof superAthlete) {
                attendAthlete.compete(type);
                swimmingAttender.add(attendAthlete);
            }
        }
    }

    private void generateAthleteAttendRunning() {
        runningAttender.clear();
        for (Participates attendAthlete : allParticipates) {
            if (attendAthlete instanceof Sprinter) {
                attendAthlete.compete();
                runningAttender.add(attendAthlete);
            } else if (attendAthlete instanceof superAthlete) {
                attendAthlete.compete(type);
                runningAttender.add(attendAthlete);
            }
        }
    }

    private void generateAthleteAttendCyclist() {
        cyclistAttender.clear();
        for (Participates attendAthlete : allParticipates) {
            if (attendAthlete instanceof Cyclist) {
                attendAthlete.compete();
                cyclistAttender.add(attendAthlete);
            } else if (attendAthlete instanceof superAthlete) {
                attendAthlete.compete(type);
                cyclistAttender.add(attendAthlete);
            }
        }
    }

    private void generateOfficial() {
        official.clear();
        for (Participates attendAthlete : allParticipates) {
            if (attendAthlete instanceof Official) {
                official.add(attendAthlete);
            }
        }
    }


    /**
     * primary method doing sorting the scores
     */
    private void startGame() {

        if (athleteChoice == 0) {
            System.out.println("You need to predict the winner!");
        } else {

            //sortedAthlete.clear();
            String menu[] = {
                    "\n---------------------------------------------",
                    "| The game only run once,if you select      |",
                    "| the option 3 many times without run again |",
                    "| The results will be the same,in order to  |",
                    "| run another game, select option 1 again   |",
                    "| to start over.                            |",
                    "---------------------------------------------\n",
                    "        RESULTS(before sorted)",
                    "=================================",
                    "ID   | Name | Age | State | Time",
            };
            for (String aMenu : menu) System.out.println(aMenu);

            displayAthleteTime(athlete);

            sortAthlete(athlete);

            System.out.println();
            System.out.println("            RESULTS(After sorted)");
            System.out.println("==============================================");
            System.out.println("Rank | ID | Name | Age | State | Time | Score ");

            displayAthleteScoreInOneGame(sortedAthlete);

            storeHistory();

            System.out.println();
            System.out.println("The referee of this game is :");
            System.out.println(referee.getID() + " " + referee.getName() + " " + referee.getAge() + " " + referee.getState());


            ifWin();
            athleteChoice = 0;
            number++;
        }
    }

    private Participates generateReferee() {
        //print the official member of this game
        Random random = new Random();
        int offNumber = random.nextInt(official.size());

        return official.get(offNumber);
    }

    /**
     * method to judge if predict the right winner
     */
    private void ifWin() {

        //print the predict result
        System.out.println();
        System.out.println("*******************************************************");
        // if to judge weather this is the topped athlete user predicted
        if (athlete.get(athleteChoice - 1).getID().equals(sortedAthlete.get(0).getID())) {
            System.out.println("Congratulation, your prediction is right!");
        } else {
            System.out.println("Sorry, maybe next time you could predict the right athletes :)");
        }

    }

    /**
     * to display all games that be ran from program start
     */
    private void displayAllResults() {

        for (Game game : gameHistory) {

            System.out.println();
            System.out.println("Game ID: " + game.getGameID());
            System.out.println("The referee of this game is: ");
            System.out.println(game.getRefree().getID() + " " + game.getRefree().getName() + " " + game.getRefree().getAge() + " " + game.getRefree().getState());
            System.out.println("******************************************");
            System.out.println();
            System.out.println("                RESULTS");
            System.out.println("=========================================");
            System.out.println("ID   | Name | Age | State | Time | Score ");
            System.out.println("=========================================");

            String[][] tempList = game.getResultOfGame();
            System.out.println(tempList[0][0] + " | " + tempList[0][1] + " | " + tempList[0][2] + " | " + tempList[0][3] + " | " + tempList[0][4] + " | 5");
            System.out.println(tempList[1][0] + " | " + tempList[1][1] + " | " + tempList[1][2] + " | " + tempList[1][3] + " | " + tempList[1][4] + " | 2");
            System.out.println(tempList[2][0] + " | " + tempList[2][1] + " | " + tempList[2][2] + " | " + tempList[2][3] + " | " + tempList[2][4] + " | 1");

            for (int i = 3; i < tempList.length; i++) {
                System.out.println(tempList[i][0] + " | " + tempList[i][1] + " | " + tempList[i][2] + " | " + tempList[i][3] + " | " + tempList[i][4] + " | 0");

            }

        }
    }

    /**
     * to display all points of athletes
     */
    private void displayAllPoints() {

        String menu[] = {
                "\n---------------------------------------------",
                "| This option will show all athletes' score |",
                "| Repeatedly attendances score will be added|",
                "| together, below will show all the points  |",
                "| from the olympic game start to run        |",
                "---------------------------------------------\n",
                "              SCORES",
                "=================================",
                "ID   | Name | Age | State | Score",
        };
        for (String aMenu : menu) System.out.println(aMenu);

        for (Participates p : allParticipates
                ) {
            if (p instanceof Swimmer || p instanceof Sprinter || p instanceof Cyclist || p instanceof superAthlete) {
                System.out.println(p.getID() + " | " + p.getName() + " | " + p.getAge() + " | " + p.getState() + " | " + p.getScore());
            }
        }
    }

    /**
     * sort the athlete and pass to sortedAthlete
     *
     * @param unsortedAthlete unsortedathlete
     */
    private void sortAthlete(ArrayList<Participates> unsortedAthlete) {

        sortedAthlete.clear();
        //get all the running time of attend athletes
        ArrayList<String> time = new ArrayList<>(unsortedAthlete.size());
        for (Participates athlete : unsortedAthlete
                ) {
            time.add(athlete.getRunningTime());
        }
        // sort the athlete score
        Collections.sort(time);

        for (int i = 0; i < unsortedAthlete.size(); i++) {
            for (int j = 0; j < time.size(); j++) {
                if (time.get(i).equals(unsortedAthlete.get(j).getRunningTime())) {
                    sortedAthlete.add(unsortedAthlete.get(j));
                }
            }
        }

        // Assign the score to athletes
        sortedAthlete.get(0).setScore(5);
        sortedAthlete.get(1).setScore(2);
        sortedAthlete.get(2).setScore(1);

        //displayAthleteScore(sortedAthlete);

/*        for (Object t : time) {
            System.out.println(t);
        }*/
    }


    /**
     * show the main selection menu
     */
    private void menuShow() {
        String menu[] = {"\n Ozlympic Game",
                "===================================",
                "1. Select a game to run",
                "2. Predict the winner of the game",
                "3. Start the game",
                "4. Display the final results of all games",
                "5. Display the points of all athletes",
                "6. Exit",
                " Enter an option:"};
        for (String aMenu : menu) System.out.println(aMenu);
    }

    /**
     * show the game select menu
     */
    private void showGameSelectMenu() {

        System.out.println("Please select one Ozlympic game to play:");
        System.out.println("1. Swimming");
        System.out.println("2. Cycling");
        System.out.println("3. Running");
    }

    private String[][] sortedListToArray(ArrayList<Participates> sortedList) {

        String[][] list = new String[sortedList.size()][6];
        for (int i = 0; i < sortedList.size(); i++) {
            list[i][0] = sortedList.get(i).getID();
            list[i][1] = sortedList.get(i).getName();
            list[i][2] = String.valueOf(sortedList.get(i).getAge());
            list[i][3] = sortedList.get(i).getState();
            list[i][4] = sortedList.get(i).getRunningTime();
            list[i][5] = String.valueOf(sortedList.get(i).getScore());

        }
        
/*        for (int i = 0; i < list.length; i++) {
                System.out.println(list[i][0]+" | "+list[i][1]+" | "+list[i][2]+" | "+list[i][3]+" | "+list[i][4]+" | "+list[i][5]);
        }*/

        return list;
    }

    private void generateNumberOfAthlete() throws outboundException {

        Random randomGenerate = new Random();
        int randomNumber = randomGenerate.nextInt(10);

        System.out.println("The number of athletes will attend game: " + randomNumber);

        if (randomNumber > 8 || randomNumber < 4) {
            throw new outboundException("Athlete number should be between 4 to 8 ! Game cancelled! Please select a game again! ");
        } else {
            numberOfAthlete = randomNumber;
        }

        //System.out.println(numberOfAthlete);
    }

    private void storeHistory() {
        switch (type) {
            case "swimming":
                if (number > 9) {
                    gameHistory.add(new Swim("" + number, sortedListToArray(sortedAthlete), referee));
                } else {
                    gameHistory.add(new Swim("0" + number, sortedListToArray(sortedAthlete), referee));
                }
                break;

            case "cycling":
                if (number > 9) {
                    gameHistory.add(new Cycle("" + number, sortedListToArray(sortedAthlete), referee));
                } else {
                    gameHistory.add(new Cycle("0" + number, sortedListToArray(sortedAthlete), referee));
                }
                break;

            case "running":
                if (number > 9) {
                    gameHistory.add(new Run("" + number, sortedListToArray(sortedAthlete), referee));
                } else {
                    gameHistory.add(new Run("0" + number, sortedListToArray(sortedAthlete), referee));
                }
                break;
        }
    }

    /**
     * main menu class which control the main selection loop
     */
    void mainMenu() throws selectOptionException {

        do {
            Scanner in = new Scanner(System.in);
            try {
                menuShow();
                choice = in.nextInt();

                if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6)
                    throw new selectOptionException("Please input right choice number! ");

                switch (choice) {
                    case 1:
                        showGameSelectMenu();
                        selectGameLoop();
                        generateNumberOfAthlete();
                        getAttendAthlete();
                        generateOfficial();
                        referee = generateReferee();
                        break;
                    case 2:
                        predictWinner();
                        break;
                    case 3:
                        startGame();
                        break;
                    case 4:
                        displayAllResults();
                        break;
                    case 5:
                        displayAllPoints();
                        break;
                    case 6:
                        System.out.println("End of Game Ozlympic ! Thanks for playing!");
                        return;
                }

            } catch (selectOptionException | outboundException e) {
                System.out.println();
            }  catch (Exception e){
                System.out.println("Please input number to select! ");
            }
        } while (true);
    }

    /**
     * generate an unrepeated number ,which can be randomly choose athlete from athletes who could attend this game
     *
     * @param size           the number of athletes who will attend the game
     * @param currentAthlete the current potential athletes
     * @return the random athlete
     */
    private Object[] generadeUnrepeatedNumber(int size, ArrayList<Participates> currentAthlete) {
        Random random = new Random();
        Object[] values = new Object[size];
        HashSet<Integer> hashSet = new HashSet<>();

        while (hashSet.size() < values.length) {
            hashSet.add(random.nextInt(currentAthlete.size()));
        }
        values = hashSet.toArray();

/*        // 遍历数组并打印数据
        for(int i = 0;i < values.length;i++){
            System.out.print(values[i] + "\t");

            if(( i + 1 ) % 10 == 0){
                System.out.println("\n");
            }
        }*/
        return values;
    }

    private void getAttendAthlete() {

        Object[] values;

        switch (type) {
            case "swimming":
                athlete.clear();
                generateAthleteAttendSwimming();
                //displayAthlete(swimmingAttender);
                values = generadeUnrepeatedNumber(numberOfAthlete, swimmingAttender);
                for (Object i : values
                        ) {
                    athlete.add(swimmingAttender.get((int) i));
                }
                displayAthlete(athlete);
                break;
            case "cycling":
                athlete.clear();
                generateAthleteAttendCyclist();
                //displayAthlete(cyclistAttender);
                values = generadeUnrepeatedNumber(numberOfAthlete, cyclistAttender);
                for (Object i : values
                        ) {
                    athlete.add(cyclistAttender.get((int) i));
                }
                displayAthlete(athlete);
                break;
            case "running":
                athlete.clear();
                generateAthleteAttendRunning();
                //displayAthlete(runningAttender);
                values = generadeUnrepeatedNumber(numberOfAthlete, runningAttender);
                for (Object i : values
                        ) {
                    athlete.add(runningAttender.get((int) i));
                }
                displayAthlete(athlete);
                break;
        }
    }

    /**
     * the selection loop of game type
     */
    private void selectGameLoop() throws selectOptionException {
        do {
            Scanner in = new Scanner(System.in);
            try {
                choice = in.nextInt();

                if (choice != 1 && choice != 2 && choice != 3)
                    throw new selectOptionException("Please input right choice number! ");

                switch (choice) {
                    case 1:
                        System.out.println("You selected Swimming and it will be started soon.");
                        System.out.println("Remember to predict a winner !");
                        type = "swimming";
                        return;
                    case 2:
                        System.out.println("You selected Cycling and it will be started soon.");
                        System.out.println("Remember to predict a winner !");
                        type = "cycling";
                        return;
                    case 3:
                        System.out.println("You selected Running and it will be started soon.");
                        System.out.println("Remember to predict a winner !");
                        type = "running";
                        return;
                }
            } catch (selectOptionException e) {
                System.out.println();
            } catch (Exception e) {
                System.out.println("Please input number to select! ");
            }
        } while (true);
    }


    /**
     * to predict the winner
     */
    private void predictWinner() {

        if (athlete.size() == 0) {
            System.out.println("You need to select the game first!");
            return;
        } else {
            System.out.println("Input the order number of Athlete to predict the winner:");
        }

        do {
            Scanner in = new Scanner(System.in);
            try {
                athleteChoice = in.nextInt();
                if (athleteChoice > athlete.size()) {
                    //when input order number larger than size of arraylist
                    System.out.println("Please input a reasonable choice!");
                } else if (athleteChoice <= 0) {
                    System.out.println("Please input an order number of athlete list above! ");
                } else {
                    System.out.println("The Athlete you predicted is:");
                    System.out.println(athlete.get(athleteChoice - 1).getID() + " " + athlete.get(athleteChoice - 1).getName() + " " + athlete.get(athleteChoice - 1).getAge() + " " + athlete.get(athleteChoice - 1).getState());
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please input an order number of athlete list above!");
            }
        } while (true);
        System.out.println();

    }


}
