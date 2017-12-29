import java.util.Random;

public class RollTheDie extends Random {

    private Random roll = new Random();

    public RollTheDie() {
    }

    public int getNextRoll() {
        return roll.nextInt(20) + 1;
    }
}
