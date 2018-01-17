import java.util.Map;
import java.util.Random;

public class RollTheDie {

    private Random random = new Random();

    RollTheDie(Random random) {
        this.random = random;
    }

    int getNextRoll() {
        return random.nextInt();
    }

    Map<String, Integer> rollForAllCharacters(CharacterMap characterMap) {

        for (Map.Entry<String, Integer> mappedCharacter : characterMap.getCharacterMap().entrySet()) {

            String name = mappedCharacter.getKey();
            Integer initBonus = mappedCharacter.getValue();

            DNDCharacter character = new DNDCharacter(name, initBonus);
            DNDInitiative initiative = new DNDInitiative(character);

            RollTheDie roll = new RollTheDie(random);

            initiative.addTheRoll(character, roll.getNextRoll());

            characterMap.updateCharacterMap(character);
        }
        return characterMap.getCharacterMap();
    }

    Map<String, Integer> rollForOneCharacter(CharacterMap characterMap, DNDCharacter character) {

            DNDInitiative initiative = new DNDInitiative(character);

            RollTheDie roll = new RollTheDie(random);

            initiative.addTheRoll(character, roll.getNextRoll());

            characterMap.updateCharacterMap(character);

        return characterMap.getCharacterMap();
    }

    // This class is for testing only
    Map<String, Integer> mockedRollForAllCharacters(CharacterMap characterMap) {

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
