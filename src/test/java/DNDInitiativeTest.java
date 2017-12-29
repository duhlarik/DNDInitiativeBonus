import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DNDInitiativeTest {

    private DNDEntity character;
    private RollTheDie mockRoll;
    private DNDInitiative initiative;

    @Before
    public void setup() {

        character = new DNDEntity("New Guy", 11);
        mockRoll = Mockito.mock(RollTheDie.class);
        initiative = new DNDInitiative(character);
    }

    @Test
    public void whenPlayerRollsTheDie_RollTheDie_IsCalled() {

        initiative.addTheRoll(character, mockRoll.getNextRoll());

        Mockito.verify(mockRoll).getNextRoll();
    }

    @Test
    public void whenPlayerRollsTheDieTheValueIsAddedToPlayersInitiativeBonus() {

        Mockito.when(mockRoll.getNextRoll()).thenReturn(6);
        initiative.addTheRoll(character, mockRoll.getNextRoll());

        Assert.assertEquals(17, character.getInitBonus());
    }
}