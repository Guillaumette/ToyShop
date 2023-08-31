package core.model;

import core.data.ToysManager;

import java.util.Scanner;

public class Exit extends Mode {

    public Exit() {
        super("exit", "выйти");
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        System.out.println("~ выход");
        System.exit(0);
    }
}
