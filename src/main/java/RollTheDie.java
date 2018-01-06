import java.util.*;

public class RollTheDie {

    private Random random = new Random();

    public RollTheDie(Random random) {
        this.random = random;
    }

    public int getNextRoll() {
        return random.nextInt();
    }

    public Map<String, Integer> rollForAllCharacters(CharacterMap characterMap) {

        Map<String, Integer> map = characterMap.getCharacterMap();

        for (Map.Entry<String, Integer> mappedCharacter : map.entrySet()) {

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
}
