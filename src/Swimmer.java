import java.util.Random;

class Swimmer extends Participates {

    Swimmer(String id, String name, int age, String state) {
        super(id, name, age, state);
    }

    @Override
    public void compete() {

        Random random = new Random();
        String time = String.format("%.2f",((random.nextDouble() * 100.0d) + 100.0d));
        setRunningTime(time);

    }
}
