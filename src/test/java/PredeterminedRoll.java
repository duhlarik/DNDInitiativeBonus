import java.util.Random;

public class PredeterminedRoll extends Random {

    @Override
    public int nextInt() {
        return 8;
    }
}
