
abstract class Game {

   private String gameID;
   private String[][] resultOfGame;
   private Participates referee;

    Game(String gameID, String[][] resultOfGame, Participates referee) {
        this.gameID = gameID;
        this.resultOfGame = resultOfGame;
        this.referee = referee;
    }

    String getGameID() {
        return gameID;
    }

    String[][] getResultOfGame() {
        return resultOfGame;
    }

    Participates getRefree() {
        return referee;
    }

}
