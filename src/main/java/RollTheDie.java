import java.util.Random;

public class RollTheDie {

    private Random roll = new Random();

    public RollTheDie(Random roll) {
        this.roll = roll;
    }

    public int getNextRoll() {
        return roll.nextInt(20) + 1;
    }
}
