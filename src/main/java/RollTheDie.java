import java.util.*;

public class RollTheDie extends Random {

    private RollTheDie roll = new RollTheDie();

    public RollTheDie() {
    }

    public int getNextRoll() {
        return roll.nextInt(20) + 1;
    }

    public int rollForAllCharacters(CharacterMap characterMap) {

        Map<String, Integer> map = characterMap.getCharacterMap();

        return 0;
    }
}
