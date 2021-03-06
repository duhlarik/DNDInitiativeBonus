public class DNDInitiative {

    private DNDCharacter character = new DNDCharacter("", 0);

    public DNDInitiative(DNDCharacter character) {
        this.character = character;
    }

    public DNDInitiative() {
    }

    public void addTheRoll(DNDCharacter character, int initiativeBonus) {

        character.setInitBonus(character.getInitBonus() + initiativeBonus);
    }


    public String retrieveCharacters() {

        String name = character.getName();
        Integer bonus = character.getInitBonus();

        return name + " -- " + bonus.toString();
    }
}
