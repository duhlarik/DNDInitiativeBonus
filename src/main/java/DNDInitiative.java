
public class DNDInitiative {

    DNDEntity character = new DNDEntity("", 0);

    public DNDInitiative(DNDEntity character) {
        this.character = character;
    }

    public void addTheRoll(DNDEntity entity, int initiativeBonus) {
        int initiativeUpdate = entity.getInitBonus() + initiativeBonus;
        entity.setInitBonus(initiativeUpdate);
    }
}
