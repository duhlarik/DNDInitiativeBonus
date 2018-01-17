public class DNDCharacter {

    private String name = "";
    private int initBonus = 0;

    DNDCharacter(String name, int initBonus) {
        this.name = name;
        this.initBonus = initBonus;
    }

    int getInitBonus() {
        return initBonus;
    }

    void setInitBonus(int initBonus) {
        this.initBonus = initBonus;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
