package core.model;

import core.data.Toy;
import core.data.ToysManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Edit extends Mode {

    public Edit() {
        super("edit", "редактировать");
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        int id;
        try {
            System.out.print("Введите id игрушки: ");
            id = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException();
        }
        Toy editToy = toys.idSearch(id);
        System.out.println(editToy);
        System.out.print("Редактировать? Д/Н ");
        String yesno = sc.next().toLowerCase().trim().strip();
        if (yesno.equals("д")) {
            editToy.setToy(getToy(toys, sc, 0));
            System.out.println("~ успешно изменено!");
        } else System.out.println("Переход в меню");
    }
}
