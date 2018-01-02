import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RollTheDieTest {

    @Test
    public void whenPlayerRollsTheDie_RollTheDie_IsCalled() {

        DNDCharacter character = new DNDCharacter("", 0);
        DNDInitiative initiative = new DNDInitiative(character);
        RollTheDie roll = new RollTheDie();

        initiative.addTheRoll(character, roll.getNextRoll());

        Mockito.verify(roll).getNextRoll();
    }

    @Test
    public void dungeonMasterCanRollForAllPlayersAtOnce() {

        CharacterMap characterMap = new CharacterMap();

        DNDCharacter character1 = new DNDCharacter("New Guy 1", -4);
        DNDCharacter character2 = new DNDCharacter("New Guy 2", 4);

        characterMap.makeCharacterMap(character1);
        characterMap.makeCharacterMap(character2);

        RollTheDie roll = Mockito.mock(RollTheDie.class);
        Mockito.when(roll.getNextRoll()).thenReturn(8);

        roll.rollForAllCharacters(characterMap);

        Map<String, Integer> map = characterMap.getCharacterMap();

        List <Integer> actualRollArray = new ArrayList<>();

        for (Map.Entry<String, Integer> characterBonus : map.entrySet()) {
            Integer value = characterBonus.getValue();
            actualRollArray.add(value);
        }

        List <Integer> expectedRollArray = new ArrayList<>(2);
        expectedRollArray.add(4);
        expectedRollArray.add(12);

        Assert.assertEquals(expectedRollArray, actualRollArray);
    }
}