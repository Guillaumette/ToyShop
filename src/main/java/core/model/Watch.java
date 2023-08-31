package core.model;

import core.data.ToysManager;

import java.util.Scanner;

public class Watch extends Mode {

    public Watch() {
        super("watch", "посмотреть");
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        if (toys.getToys() != null) System.out.println(toys);
        else System.out.println("Ошибка: игрушек нет в базе");
    }
}
