public class DNDCharacter {

    private String name = "";
    private int initBonus = 0;

    public DNDCharacter(String name, int initBonus) {
        this.name = name;
        this.initBonus = initBonus;
    }

    int getInitBonus() {
        return initBonus;
    }

    public void setInitBonus(int initBonus) {
        this.initBonus = initBonus;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
