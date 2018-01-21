import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class BattleTest {

    @Test
    public void dungeonMasterCanAssignASortedCharacterMapToABattle() {

        Battle battle = new Battle();
        battle.setBattle("Battle of Five Armies");

        CharacterMap characterMap = new CharacterMap();

        DNDCharacter Legelaric = new DNDCharacter("Legelaric", -5);
        DNDCharacter Legalidda = new DNDCharacter("Legalidda", 17);
        DNDCharacter Dwaydda = new DNDCharacter("Dwaydda", 2);
        DNDCharacter Ulorin = new DNDCharacter("Ulorin", 9);

        characterMap.updateCharacterMap(Legelaric);
        characterMap.updateCharacterMap(Legalidda);
        characterMap.updateCharacterMap(Dwaydda);
        characterMap.updateCharacterMap(Ulorin);

        Map<String, Integer> sortedCharacterMap = characterMap.retrieveSortedCharacterMap(characterMap);

        Map<String, Map<String, Integer>> battleCharacters = battle.assignCharactersToABattle(battle, sortedCharacterMap);

        StringBuilder actualBattle = new StringBuilder();

        for (Map.Entry<String, Map<String, Integer>> battleCharacter : battleCharacters.entrySet()) {

            String battleName = battleCharacter.getKey();
            actualBattle.append(battleName).append(":\n");

            for (Map.Entry<String, Integer> character : battleCharacter.getValue().entrySet()) {

                String characterName = character.getKey();
                Integer initBonus = character.getValue();

                actualBattle.append(characterName).append(" -- ").append(initBonus).append("\n");
            }
        }

        battle.printBattleCharacterList(battleCharacters);

        String expected = "Battle of Five Armies:\n" + "Legalidda -- 17\n" + "Ulorin -- 9\n" + "Dwaydda -- 2\n" + "Legelaric -- -5\n";

        Assert.assertEquals(expected, actualBattle.toString());
    }
}