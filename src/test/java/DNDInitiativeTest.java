import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DNDInitiativeTest {

    private DNDCharacter character;
    private RollTheDie roll;
    private DNDInitiative initiative;
    private CharacterMap characterMap;

    @Before
    public void setup() {

        character = new DNDCharacter("Fraullan", 11);
        initiative = new DNDInitiative(character);
        characterMap = new CharacterMap();
        roll = Mockito.mock(RollTheDie.class);
        when(roll.getNextRoll()).thenReturn(6);
    }

    @Test
    public void whenPlayerRollsTheDieTheValueIsAddedToPlayersInitiativeBonus() {

        initiative.addTheRoll(character, roll.getNextRoll());

        assertEquals(17, character.getInitBonus());
    }

    @Test
    public void dungeonMasterIsAbleToRetrieveACharactersNameAndInitBonus() {

        initiative.addTheRoll(character, roll.getNextRoll());

        assertEquals("Fraullan -- 17", initiative.retrieveCharacters());
    }
}