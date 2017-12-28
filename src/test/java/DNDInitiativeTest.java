import org.junit.Assert;
import org.junit.Test;

public class DNDInitiativeTest {

    @Test
    public void whenPlayerRollsTheDieTheValueIsAddedToPlayersInitiativeBonus() {

        DNDEntity character = new DNDEntity("New Guy", 11);
        PredeterminedRoll predeterminedRoll = new PredeterminedRoll();
        RollTheDie roll = new RollTheDie(predeterminedRoll);
        DNDInitiative initiative = new DNDInitiative(character);
        int initiativeBonus = roll.getNextRoll() + character.getInitBonus();
        initiative.addTheRoll(character, initiativeBonus);

        Assert.assertEquals(25, character.getInitBonus());
    }
}