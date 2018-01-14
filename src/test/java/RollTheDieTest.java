import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RollTheDieTest {

    private PredeterminedRoll predeterminedRoll;
    private CharacterMap characterMap;

    @Before
    public void setUp() {

        characterMap = new CharacterMap();
        predeterminedRoll = new PredeterminedRoll();
    }

    @Test
    public void whenPlayerRollsTheDie_RollTheDie_IsCalled() {

        DNDCharacter character = new DNDCharacter("Uniadric", 0);
        DNDInitiative initiative = new DNDInitiative(character);
        RollTheDie roll = mock(RollTheDie.class);

        initiative.addTheRoll(character, roll.getNextRoll());

        verify(roll).getNextRoll();
    }

    @Test
    public void dungeonMasterCanRollForAllPlayersAtOnce() {

        DNDCharacter Asoaria = new DNDCharacter("Asoaria", -4);
        DNDCharacter Jerelith = new DNDCharacter("Jerelith", 4);

        characterMap.updateCharacterMap(Asoaria);
        characterMap.updateCharacterMap(Jerelith);

        RollTheDie roll = new RollTheDie(predeterminedRoll);

        roll.rollForAllCharacters(characterMap);

        List<Integer> actualRollArray = new ArrayList<>();

        for (Map.Entry<String, Integer> characterBonus : characterMap.getCharacterMap().entrySet()) {
            Integer value = characterBonus.getValue();
            actualRollArray.add(value);
        }

        assertThat(actualRollArray, containsInAnyOrder(4, 12));
    }

    @Test
    public void dungeonMasterCanRollForOneCharacterAtATime() {

        RollTheDie roll = new RollTheDie(predeterminedRoll);

        DNDCharacter Kusien = new DNDCharacter("Kusien", 19);
        DNDCharacter Greld = new DNDCharacter("Greld", 4);
        DNDCharacter Astywiel = new DNDCharacter("Astywiel", 14);

        characterMap.updateCharacterMap(Kusien);
        characterMap.updateCharacterMap(Greld);
        characterMap.updateCharacterMap(Astywiel);

        roll.rollForOneCharacter(characterMap, Astywiel);

        int initBonus = 0;

        for (Map.Entry<String, Integer> character : characterMap.getCharacterMap().entrySet()) {
            if (character.getKey().equals("Astywiel")) {

                initBonus = character.getValue();
            }
        }

        assertThat(initBonus, is(22));
    }
}