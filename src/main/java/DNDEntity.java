
public class DNDEntity {

    String name = "";
    int initBonus = 0;

    public DNDEntity(String name, int initBonus) {
        this.name = name;
        this.initBonus = initBonus;
    }

    public int getInitBonus() {
        return initBonus;
    }

    public void setInitBonus(int initBonus) {
        this.initBonus = initBonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
