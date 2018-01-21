import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CharacterMapTest {

    private CharacterMap characterMap;

    @Before
    public void setUp() {

        characterMap = new CharacterMap();

    }

    @Test
    public void dungeonMasterIsAbleToAddCharactersToTheCharacterMap() {

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

        assertEquals(expectedMap, characterMap.getCharacterMap());
    }

    @Test
    public void dungeonMasterIsAbleToSortTheCharacterMapByInitBonus() {

        DNDCharacter Grienidd = new DNDCharacter("Grienidd", 13);
        DNDCharacter Adaumeth = new DNDCharacter("Adaumeth", -2);
        DNDCharacter Rhaleron = new DNDCharacter("Rhaleron", 7);

        characterMap.updateCharacterMap(Grienidd);
        characterMap.updateCharacterMap(Adaumeth);
        characterMap.updateCharacterMap(Rhaleron);

        Map<String, Integer> sortedCharacterMap = characterMap.sortCharacterMapByValue(characterMap);

        List<Integer> actualArray = new ArrayList<>();

        for (Map.Entry<String, Integer> characterBonus : sortedCharacterMap.entrySet()) {
            Integer value = characterBonus.getValue();
            actualArray.add(value);
        }

        int valueAtZero = actualArray.get(0);
        int valueAtOne = actualArray.get(1);
        int valueAtTwo = actualArray.get(2);

        assertEquals(13, valueAtZero);
        assertEquals(7, valueAtOne);
        assertEquals(-2, valueAtTwo);
    }

    @Test
    public void dungeonMasterIsAbleToRemoveACharacterByNameFromTheCharacterMap() {

        DNDCharacter Kedelaviel = new DNDCharacter("Kedelaviel", -1);
        DNDCharacter Daleseth = new DNDCharacter("Daleseth", 11);
        DNDCharacter Onilanwan = new DNDCharacter("Onilanwan", 7);

        characterMap.updateCharacterMap(Kedelaviel);
        characterMap.updateCharacterMap(Daleseth);
        characterMap.updateCharacterMap(Onilanwan);

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("Kedelaviel", -1);
        expectedMap.put("Daleseth", 11);
        expectedMap.put("Onilanwan", 7);

        assertEquals(expectedMap, characterMap.getCharacterMap());

        characterMap.removeACharacterByName(Kedelaviel);

        expectedMap.remove("Kedelaviel");

        assertEquals(expectedMap, characterMap.getCharacterMap());
    }

    @Test
    public void ifANameDoesNotExistInTheCharacterMapTheDMWillBeNotified() {

        DNDCharacter Riev = new DNDCharacter("Riev", -5);
        DNDCharacter Felidda = new DNDCharacter("Felidda", 17);
        DNDCharacter Lothien = new DNDCharacter("Lothien", 2);
        DNDCharacter Ulorevia = new DNDCharacter("Ulorevia", 9);

        characterMap.updateCharacterMap(Riev);
        characterMap.updateCharacterMap(Felidda);
        characterMap.updateCharacterMap(Lothien);

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("Riev", -5);
        expectedMap.put("Felidda", 17);
        expectedMap.put("Lothien", 2);

        assertEquals(expectedMap, characterMap.getCharacterMap());

        characterMap.removeACharacterByName(Ulorevia);

        assertEquals(expectedMap, characterMap.getCharacterMap());
    }

    @Test
    public void dungeonMasterIsAbleToRetrieveAllCharactersInInitiativeOrder() {

        DNDCharacter Yomahar = new DNDCharacter("Yomahar", 12);
        DNDCharacter Pryde = new DNDCharacter("Pryde", -3);
        DNDCharacter Hairenwan = new DNDCharacter("Hairenwan", 19);

        characterMap.updateCharacterMap(Yomahar);
        characterMap.updateCharacterMap(Pryde);
        characterMap.updateCharacterMap(Hairenwan);

        Map<String, Integer> sortedCharacterMap = characterMap.retrieveSortedCharacterMap(characterMap);

        StringBuilder actual = new StringBuilder();

        for (Map.Entry<String, Integer> sortedCharacter : sortedCharacterMap.entrySet()) {
            String info = sortedCharacter.getKey() + " -- " + sortedCharacter.getValue().toString() + "\n";
            actual.append(info);
        }

        characterMap.printSortedCharacterMap(sortedCharacterMap);

        String expected = "Hairenwan -- 19\n" + "Yomahar -- 12\n" + "Pryde -- -3\n";

        assertEquals(expected, actual.toString());
    }
}