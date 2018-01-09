import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterMapTest {

    @Test
    public void dungeonMasterIsAbleToAddCharactersToTheCharacterMap() {

        CharacterMap characterMap = new CharacterMap();

        DNDCharacter Eroang = new DNDCharacter("Eroang", 13);
        DNDCharacter Trerrathiel = new DNDCharacter("Trerrathiel", -2);
        DNDCharacter Thidus = new DNDCharacter("Thidus", 7);

        characterMap.updateCharacterMap(Eroang);
        characterMap.updateCharacterMap(Trerrathiel);
        characterMap.updateCharacterMap(Thidus);

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("Eroang", 13);
        expectedMap.put("Trerrathiel", -2);
        expectedMap.put("Thidus", 7);

        Assert.assertEquals(characterMap.getCharacterMap(),expectedMap);

    }

    @Test
    public void dungeonMasterIsAbleToSortTheCharacterMapByInitBonus() {

        CharacterMap characterMap = new CharacterMap();

        DNDCharacter Eroang = new DNDCharacter("Eroang", 13);
        DNDCharacter Trerrathiel = new DNDCharacter("Trerrathiel", -2);
        DNDCharacter Thidus = new DNDCharacter("Thidus", 7);

        characterMap.updateCharacterMap(Eroang);
        characterMap.updateCharacterMap(Trerrathiel);
        characterMap.updateCharacterMap(Thidus);

        Map<String, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put("Trerrathiel", -2);
        expectedMap.put("Thidus", 7);
        expectedMap.put("Eroang", 13);

        characterMap.sortCharacterMapByValue(characterMap);

        Assert.assertEquals(characterMap.getCharacterMap(), expectedMap);
    }
}