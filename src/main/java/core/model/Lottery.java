package core.model;

import core.data.Client;
import core.data.Toy;
import core.data.ToysManager;

import java.util.*;


public class Lottery extends Mode {
    private List<Integer> id;
    private List<Short> chance;
    private int sumChance;
    private int count;

    public Lottery() {
        super("start", "начать розыгрыш");
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        if (toys.getToys() == null) {
            System.out.println("Сначала создайте перечень игрушек");
            throw new NullPointerException();
        } else {
            System.out.print("Введите ваше имя: ");
            String name = sc.next().trim().strip();
            Client client = new Client(name);
            prepare(toys.getToys());
            List<String> resultLot = new LinkedList<>();
            boolean game = true;
            do {
                System.out.println(name + ", нажмите Enter, чтобы играть");
                sc.next();
                Toy result = toys.idSearch(randomGen());
                System.out.println("Поздравляем! Ваш выигрыш ~" + result.getName() + "~");
                resultLot.add(result.getName());
                System.out.println("Игрушек осталось: " + --count);
                if (toys.removeDecrease(result)) prepare(toys.getToys());
                System.out.println("\nЖелаете продолжить розыгрыш?  Д/Н");
                String yesno = sc.next().trim().strip().toLowerCase();
                if (!yesno.equals("д")) game = false;
                if (count == 0) {
                    game = false;
                    System.out.println("Все игрушки разыграны!");
                }
            } while (game);
            client.setWins(resultLot);
            client.toFile();
        }
    }

    /**
     * @apiNote предварительная подготовка состояния класса для генерации лотереи
     * @param toys список игрушек
     */
    public void prepare(Queue<Toy> toys) {
        id = new ArrayList<>();
        chance = new ArrayList<>();
        sumChance = 0;
        count = 0;
        for (Toy toy : toys) {
            this.id.add(toy.getId());
            this.chance.add(toy.getFailingChance());
            this.sumChance += toy.getFailingChance();
            this.count += toy.getQty();
        }
    }

    /**
     * @apiNote метод генерации лотереи через случайное число и мнимый массив
     * @return id игрушки
     */
    private int randomGen() {
        Random rd = new Random();
        int idx = rd.nextInt(sumChance);
        for (int i = 0; i < chance.size(); i++) {
            idx -= chance.get(i);
            if (idx < 0) {
                return id.get(i);
            }
        }
        return -1;
    }
}
