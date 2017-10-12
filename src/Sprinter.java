import java.util.Random;

class Sprinter extends Participates {

    Sprinter(String id, String name, int age, String state) {
        super(id, name, age, state);
    }

    @Override
    public void compete() {

        Random random = new Random();
        String time = String.format("%.2f",((random.nextDouble() * 10.0d) + 10.0d));
        setRunningTime(time);

    }
}
