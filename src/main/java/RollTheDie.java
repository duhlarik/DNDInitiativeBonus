import java.util.*;

public class RollTheDie extends Random {

    private RollTheDie roll = new RollTheDie();
    private DNDInitiative initiative;
    private DNDCharacter character;

    public RollTheDie() {
    }

    public int getNextRoll() {
        return roll.nextInt(20) + 1;
    }


    public Map<String, Integer> rollForAllCharacters(CharacterMap characterMap) {

        Map<String, Integer> map = characterMap.getCharacterMap();

        for (Map.Entry<String, Integer> mappedCharacter : map.entrySet()) {

            String name = mappedCharacter.getKey();
            Integer initBonus = mappedCharacter.getValue();

            character = new DNDCharacter(name, initBonus);
            initiative = new DNDInitiative(character);

            initiative.addTheRoll(character, roll.getNextRoll());

            characterMap.updateCharacterMap(character);
        }
        return characterMap.getCharacterMap();
    }
}
