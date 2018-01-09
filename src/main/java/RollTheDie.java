import java.util.Map;
import java.util.Random;

public class RollTheDie {

    private Random random = new Random();

    public RollTheDie(Random random) {
        this.random = random;
    }

    public int getNextRoll() {
        return random.nextInt(20) +1;
    }

    private RollTheDie roll;

    public Map<String, Integer> rollForAllCharacters(CharacterMap characterMap) {

        for (Map.Entry<String, Integer> mappedCharacter : characterMap.getCharacterMap().entrySet()) {

            String name = mappedCharacter.getKey();
            Integer initBonus = mappedCharacter.getValue();

            DNDCharacter character = new DNDCharacter(name, initBonus);
            DNDInitiative initiative = new DNDInitiative(character);

            initiative.addTheRoll(character, roll.getNextRoll());

            characterMap.updateCharacterMap(character);
        }
        return characterMap.getCharacterMap();
    }

    // This class is for testing only
    public Map<String, Integer> mockedRollForAllCharacters(CharacterMap characterMap) {

        for (Map.Entry<String, Integer> mappedCharacter : characterMap.getCharacterMap().entrySet()) {

            String name = mappedCharacter.getKey();
            Integer initBonus = mappedCharacter.getValue();

            DNDCharacter character = new DNDCharacter(name, initBonus);
            DNDInitiative initiative = new DNDInitiative(character);

            int mockInitiativeRoll = 8;

            initiative.addTheRoll(character, mockInitiativeRoll);

            characterMap.updateCharacterMap(character);
        }
        return characterMap.getCharacterMap();
    }
}
