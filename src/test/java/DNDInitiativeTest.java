import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DNDInitiativeTest {

    @Test
    public void whenPlayerRollsTheDie_RollTheDie_IsCalled() {

        DNDEntity character = new DNDEntity("New Guy", 11);
        RollTheDie mockRoll = Mockito.mock(RollTheDie.class);
        DNDInitiative initiative = new DNDInitiative(character);
        initiative.addTheRoll(character, mockRoll.getNextRoll());

        Mockito.verify(mockRoll).getNextRoll();
    }
    @Test
    public void whenPlayerRollsTheDieTheValueIsAddedToPlayersInitiativeBonus() {

        DNDEntity character = new DNDEntity("New Guy", 11);
        RollTheDie mockRoll = Mockito.mock(RollTheDie.class);
        DNDInitiative initiative = new DNDInitiative(character);
        Mockito.when(mockRoll.getNextRoll()).thenReturn(6);
        initiative.addTheRoll(character, mockRoll.getNextRoll());

        Assert.assertEquals(17, character.getInitBonus());
    }
}