package core.data;

import java.util.PriorityQueue;
import java.util.Queue;

public class ToysManager {
    private Queue<Toy> toys;

    public ToysManager(Queue<Toy> toys) {
        this.toys = toys;
    }

    public ToysManager() {

    }

    public Queue<Toy> getToys() {
        return toys;
    }

    public void setToys(Queue<Toy> toys) {
        this.toys = toys;
    }

    public void addToy(Toy toy) {
        toys.offer(toy);
    }

    /**
     * @apiNote метод для исключения повторения id путем нахождения максимального
     * @return max id
     */
    public int findMaxId() {
        if (toys == null) {
            this.toys = new PriorityQueue<>();
            return 1;
        }
        int max = 0;
        for (Toy toy : toys) {
            if (toy.getId() > max) max = toy.getId();
        }
        return max;
    }

    /**
     * @apiNote поиск игрушки в списке toys по id
     * @param search заданный id
     * @return соответствующая игрушка или null
     */
    public Toy idSearch(int search) {
        for (Toy toy : toys) {
            if (toy.getId() == search) return toy;
        }
        return null;
    }

    /**
     * @apiNote уменьшение кол-ва игрушек при выигрыше и удаление экземпляра, если кол-во 0
     * @param toy игрушка, экземпляр класса Toy
     * @return true или false
     */
    public boolean removeDecrease(Toy toy) {
        toy.decreaseQty();
        if (toy.getQty() == 0) {
            toys.remove(toy);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Toy toy : toys) {
            result.append(toy.toString());
        }
        return result.toString();
    }
}