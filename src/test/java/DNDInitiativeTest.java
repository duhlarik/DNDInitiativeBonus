import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DNDInitiativeTest {

    private DNDCharacter character;
    private RollTheDie roll;
    private DNDInitiative initiative;

    @Before
    public void setup() {

        roll = Mockito.mock(RollTheDie.class);
        character = new DNDCharacter("New Guy", 11);
        initiative = new DNDInitiative(character);
        Mockito.when(roll.getNextRoll()).thenReturn(6);
    }

    @Test
    public void whenPlayerRollsTheDieTheValueIsAddedToPlayersInitiativeBonus() {

        initiative.addTheRoll(character, roll.getNextRoll());

        Assert.assertEquals(17, character.getInitBonus());
    }

    @Test
    public void dungeonMasterIsAbleToRetrieveACharactersNameAndInitBonus() {

        int initiativeToAdd = roll.getNextRoll();
        initiative.addTheRoll(character, initiativeToAdd);

        Assert.assertEquals("New Guy -- 17", initiative.retrieveCharacters());
    }
}