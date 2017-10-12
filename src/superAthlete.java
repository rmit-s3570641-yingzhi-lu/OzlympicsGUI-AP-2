import java.util.Random;

class superAthlete extends Participates {

    superAthlete(String id, String name, int age, String state) {
        super(id, name, age, state);
    }

    public void compete(String  type) {

        Random random = new Random();

        String time = null;

        //1--swimming 2--cyclist 3--sprinter

        switch(type){
            case "swimming":
                time=String.format("%.2f",((random.nextDouble() * 100.0d) + 100.0d));
                break;
            case "cycling":
                time=String.format("%.2f",((random.nextDouble() * 300.0d) + 500.0d));
                break;
            case "running":
                time=String.format("%.2f",((random.nextDouble() * 10.0d) + 10.0d));
                break;
        }

        setRunningTime(time);

    }

}
