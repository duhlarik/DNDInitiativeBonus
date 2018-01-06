import java.util.Random;

public class PredeterminedRoll extends Random {

    public PredeterminedRoll() {
        super();
    }

    public int nextInt() {
        return 8;
    }
}
