import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DNDInitiativeTest {

    private DNDEntity character;
    private RollTheDie roll;
    private DNDInitiative initiative;

    @Before
    public void setup() {

        roll = Mockito.mock(RollTheDie.class);
        character = new DNDEntity("New Guy", 11);
        initiative = new DNDInitiative(character);
        Mockito.when(roll.getNextRoll()).thenReturn(6);
    }

    @Test
    public void whenPlayerRollsTheDie_RollTheDie_IsCalled() {

        initiative.addTheRoll(character, roll.getNextRoll());

        Mockito.verify(roll).getNextRoll();
    }

    @Test
    public void whenPlayerRollsTheDieTheValueIsAddedToPlayersInitiativeBonus() {

        initiative.addTheRoll(character, roll.getNextRoll());

        Assert.assertEquals(17, character.getInitBonus());
    }

    @Test
    public void dungeonMasterIsAbleToRetrieveCharactersNameAndInitBonus() {

        int initiativeToAdd = roll.getNextRoll();
        initiative.addTheRoll(character, initiativeToAdd);

        Assert.assertEquals("New Guy -- 17", initiative.retrieveCharacters());
    }
}