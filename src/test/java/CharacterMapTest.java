import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        Map<String, Integer> sortedCharacterMap = characterMap.sortCharacterMapByValue(characterMap);

        List<Integer> actualArray = new ArrayList<>();

        for (Map.Entry<String, Integer> characterBonus : sortedCharacterMap.entrySet()) {
            Integer value = characterBonus.getValue();
            actualArray.add(value);
        }

        int valueAtZero = actualArray.get(0);
        int valueAtOne = actualArray.get(1);
        int valueAtTwo = actualArray.get(2);

        Assert.assertEquals(13, valueAtZero);
        Assert.assertEquals(7, valueAtOne);
        Assert.assertEquals(-2, valueAtTwo);
    }
}