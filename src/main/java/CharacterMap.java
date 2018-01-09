import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class CharacterMap {

    private Map<String, Integer> characterMap = new HashMap<>();

    public Map<String, Integer> updateCharacterMap(DNDCharacter character) {

        characterMap.put(character.getName(), character.getInitBonus());

        return characterMap;
    }

    public Map<String, Integer> sortCharacterMapByValue(CharacterMap characterMap) {

        Map<String, Integer> sortedCharacterMap;

        sortedCharacterMap = characterMap
                .getCharacterMap()
                .entrySet()
                .stream()
                .sorted(comparingByValue(Collections.reverseOrder()))
                .collect(toMap(Entry::getKey, Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return sortedCharacterMap;
    }

    public Map<String, Integer> getCharacterMap() {
        return characterMap;
    }
}
