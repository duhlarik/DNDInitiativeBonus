import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class RollTheDieTest {

        private PredeterminedRoll predeterminedRoll = new PredeterminedRoll();

    @Test
    public void whenPlayerRollsTheDie_RollTheDie_IsCalled() {

        DNDCharacter character = new DNDCharacter("", 0);
        DNDInitiative initiative = new DNDInitiative(character);
        RollTheDie roll = Mockito.mock(RollTheDie.class);

        initiative.addTheRoll(character, roll.getNextRoll());

        Mockito.verify(roll).getNextRoll();
    }

    @Test
    public void dungeonMasterCanRollForAllPlayersAtOnce() {

        CharacterMap characterMap = new CharacterMap();

        DNDCharacter Asoaria = new DNDCharacter("Asoaria", -4);
        DNDCharacter Jerelith = new DNDCharacter("Jerelith", 4);

        characterMap.updateCharacterMap(Asoaria);
        characterMap.updateCharacterMap(Jerelith);

        RollTheDie roll = new RollTheDie(predeterminedRoll);

        roll.mockedRollForAllCharacters(characterMap);

        List <Integer> actualRollArray = new ArrayList<>();

        for (Map.Entry<String, Integer> characterBonus : characterMap.getCharacterMap().entrySet()) {
            Integer value = characterBonus.getValue();
            actualRollArray.add(value);
        }

        assertThat(actualRollArray, containsInAnyOrder(4, 12));
    }
}