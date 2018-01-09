import java.util.HashMap;
import java.util.Map;

public class CharacterMap {

    private Map<String, Integer> characterMap = new HashMap<>();

    public Map<String, Integer> updateCharacterMap(DNDCharacter character) {

        characterMap.put(character.getName(), character.getInitBonus());

        return characterMap;
    }

    public Map<String, Integer> sortCharacterMapByValue(CharacterMap characterMap) {

        Map<String, Integer> sortedCharacterMap = new HashMap<>();
        return sortedCharacterMap;
    }

    public Map<String, Integer> getCharacterMap() {
        return characterMap;
    }
}