
public class DNDInitiative {

    private DNDCharacter character = new DNDCharacter("", 0);

    public DNDInitiative(DNDCharacter character) {
        this.character = character;
    }

    public void addTheRoll(DNDCharacter character, int initiativeBonus) {
        int initiativeUpdate = character.getInitBonus() + initiativeBonus;
        character.setInitBonus(initiativeUpdate);
    }

    public String retrieveCharacters() {
        String name = character.getName();
        Integer bonus = character.getInitBonus();
        return name + " -- " + bonus.toString();
    }
}
