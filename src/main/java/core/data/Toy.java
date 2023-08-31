package core.data;

public class Toy implements Comparable<Toy> {
    private int id;
    private short failingChance;
    private Integer qty;
    private String name;

    public Toy(int id, short failingChance, Integer qty, String name) {
        this.id = id;
        this.failingChance = failingChance;
        this.qty = qty;
        this.name = name;
    }

    public Toy() {
    }

    public int getId() {
        return id;
    }

    public short getFailingChance() {
        return failingChance;
    }

    public Integer getQty() {
        return qty;
    }

    public String getName() {
        return name;
    }

    public void setToy(Toy toy) {
        this.id = toy.getId();
        this.failingChance = toy.getFailingChance();
        this.qty = toy.getQty();
        this.name = toy.getName();
    }

    public void decreaseQty() {
        this.qty -= 1;
    }

    @Override
    public String toString() {
        return "Игрушка: " + name + "\", количество: [" + qty + "], шанс выпадения [" + failingChance + "%]\n";
    }

    @Override
    public int compareTo(Toy o) {
        return Short.compare(o.failingChance, this.failingChance);
    }
}