import java.util.HashMap;
import java.util.Map;

public class Battle {

    private String battle = "";
    private Map<String, Map<String, Integer>> battleMap = new HashMap<>();

    public Battle() {
    }

    public String getBattle() {
        return battle;
    }

    public void setBattle(String battle) {
        this.battle = battle;
    }

    public Map<String, Map<String, Integer>> assignCharactersToABattle(Battle battle, Map<String, Integer> sortedCharacterMap) {

        battleMap.put(battle.getBattle(), sortedCharacterMap);

        return battleMap;
    }

    public void printBattleCharacterList(Map<String, Map<String, Integer>> battleMap) {

        for (Map.Entry<String, Map<String, Integer>> battleCharacter : battleMap.entrySet()) {

            String battleName = battleCharacter.getKey();
            System.out.println(battleName + ":");

            for (Map.Entry<String, Integer> character : battleCharacter.getValue().entrySet()) {

                String characterName = character.getKey();
                System.out.print("\t" + characterName);
                Integer initBonus = character.getValue();
                System.out.println(" -- " + initBonus);
            }
        }
    }
}
