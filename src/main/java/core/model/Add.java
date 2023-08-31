package core.model;

import core.data.ToysManager;

import java.util.Scanner;

public class Add extends Mode {
    public Add() {
        super("add", "добавить");
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        toys.addToy(getToy(toys, sc, 1));
        System.out.println("~ успешно добавлено!");
    }
}
