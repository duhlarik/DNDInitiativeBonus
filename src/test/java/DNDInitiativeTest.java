import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DNDInitiativeTest {

    private DNDCharacter character;
    private DNDInitiative initiative;
    private PredeterminedRoll predeterminedRoll = new PredeterminedRoll();

    @Before
    public void setup() {

        character = new DNDCharacter("Fraullan", 11);
        initiative = new DNDInitiative(character);
    }

    @Test
    public void dungeonMasterIsAbleToRetrieveACharactersNameAndInitBonus() {

        assertEquals("Fraullan -- 11", initiative.retrieveCharacters());
    }

    @Test
    public void aPlayerCanManuallyRollTheDieAndTheValueIsAddedToPlayersInitiativeBonus() {

        initiative.addTheRoll(character, 10);

        assertEquals(21, character.getInitBonus());
    }
}