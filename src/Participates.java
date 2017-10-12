
abstract class Participates{

    private String ID;
    private String name;
    private int age;
    private String state;
    private String runningTime;

    //record the score of this participate
    private int score;

    //constructor for official
    Participates(String id, String name, int age, String state) {
        this.ID = id;
        this.name = name;
        this.age = age;
        this.state = state;
    }

    public void compete() {}

    public void compete(String type) {}

    String getID() {
        return ID;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getState() {
        return state;
    }

    String getRunningTime() {
        return runningTime;
    }

    void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score += score;
    }

}
