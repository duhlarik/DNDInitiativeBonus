import java.util.Map;
import java.util.Random;

public class RollTheDie {

    private RollTheDie roll;
    private Random random = new Random();
    private DNDCharacter character;
    private DNDInitiative initiative = new DNDInitiative();

    RollTheDie(Random random) {
        this.random = random;
    }

    int getNextRoll() {
        return random.nextInt(20) + 1;
    }

    Map<String, Integer> rollForAllCharacters(CharacterMap characterMap) {

            roll = new RollTheDie(random);

        for (Map.Entry<String, Integer> mappedCharacter : characterMap.getCharacterMap().entrySet()) {

            String name = mappedCharacter.getKey();
            Integer initBonus = mappedCharacter.getValue();

            character = new DNDCharacter(name, initBonus);

            initiative.addTheRoll(character, roll.getNextRoll());

            characterMap.updateCharacterMap(character);
        }
        return characterMap.getCharacterMap();
    }

    Map<String, Integer> rollForOneCharacter(CharacterMap characterMap, DNDCharacter character) {

        roll = new RollTheDie(random);

        initiative.addTheRoll(character, roll.getNextRoll());

        characterMap.updateCharacterMap(character);

        return characterMap.getCharacterMap();
    }
}
