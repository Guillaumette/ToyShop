package core.model;

import core.data.Toy;
import core.data.ToysManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Mode {
    protected String nameMenu;
    protected String desc;

    public Mode(String nameMenu, String desc) {
        this.nameMenu = nameMenu;
        this.desc = desc;
    }

    public abstract void execute(ToysManager toys, Scanner sc);

    public String getNameMenu() {
        return nameMenu;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * @param toys список игрушек
     * @param sc   ввод пользователем в консоль
     * @param id   разница, чтобы индекс не менялся при редактировании
     * @return новая игрушка, новый экземпляр класса Toy
     * @apiNote метод, благодаря которому пользователь создает экземпляр класса Toy
     */
    protected Toy getToy(ToysManager toys, Scanner sc, int id) {
        System.out.print("Введите имя игрушки: ");
        String name = sc.next().trim().strip();
        short failingChance;
        int qty;
        try {
            System.out.print("Введите количество игрушек: ");
            qty = sc.nextInt();
            System.out.print("Введите шанс выпадения игрушки (от 1 до 99: ");
            failingChance = sc.nextShort();
            if (failingChance < 1 || failingChance > 99) throw new InputMismatchException();
        } catch (InputMismatchException e) {
            throw new RuntimeException();
        }
        return new Toy(toys.findMaxId() + id, failingChance, qty, name);
    }
}
