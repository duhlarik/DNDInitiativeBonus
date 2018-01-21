import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DNDInitiativeTest {

    private DNDCharacter character;
    private RollTheDie roll;
    private DNDInitiative initiative;

    @Before
    public void setup() {

        character = new DNDCharacter("Fraullan", 11);
        initiative = new DNDInitiative(character);
        PredeterminedRoll predeterminedRoll = new PredeterminedRoll();
        roll = new RollTheDie(predeterminedRoll);
    }

    @Test
    public void whenPlayerRollsTheDieTheValueIsAddedToPlayersInitiativeBonus() {

        initiative.addTheRoll(character, roll.getNextRoll());

        assertEquals(19, character.getInitBonus());
    }

    @Test
    public void dungeonMasterIsAbleToRetrieveACharactersNameAndInitBonus() {

        initiative.addTheRoll(character, roll.getNextRoll());

        assertEquals("Fraullan -- 19", initiative.retrieveCharacters());
    }
}