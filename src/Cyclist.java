import java.util.Random;

public class Cyclist extends Participates {

    Cyclist(String id, String name, int age, String state) {
        super(id, name, age, state);
    }

    @Override
    public void compete() {

        Random random = new Random();
        String time = String.format("%.2f", ((random.nextDouble() * 300.0d) + 500.0d));
        setRunningTime(time);

    }
}
