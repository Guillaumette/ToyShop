package core.control;

import core.data.ToysManager;
import core.model.Mode;

import java.util.Map;
import java.util.Scanner;

public class Control implements ControlBase {
    private final Map<String, Mode> modes;
    private final ToysManager toys;

    public Control(ToysManager toys, Map<String, Mode> modes) {
        this.modes = modes;
        this.toys = toys;
    }

    /**
     * @apiNote метод для вывода меню в консоль
     * @return максимальный размер названия и описания меню
     */
    public int[] SizeMenu() {
        int maxName = 0;
        int maxDesc = 0;
        for (Map.Entry<String, Mode> mode : modes.entrySet()) {
            if (mode.getValue().getNameMenu().length() > maxName) {
                maxName = mode.getValue().getNameMenu().length();
            }
            if (mode.getValue().getDesc().length() > maxDesc) {
                maxDesc = mode.getValue().getDesc().length();
            }
        }
        return new int[]{maxName, maxDesc};
    }

    /**
     * @apiNote основной метод исполнения
     * @param item ключ map для выполнения команды
     * @param sc взаимодействие с консолью
     */
    @Override
    public void onExecute(String item, Scanner sc){
        try {
            modes.get(item).execute(toys, sc);
        } catch (RuntimeException e) {
            System.out.println("Ошибка: введено неверное значение!");
        }
    }

    @Override
    public String toString() {
        StringBuilder main = new StringBuilder();
        int[] size = SizeMenu();
        main.append("-".repeat(size[0]))
                .append("   ")
                .append("-".repeat(size[1]))
                .append("\n");
        for (Map.Entry<String, Mode> mode : modes.entrySet()) {
            main.append(mode.getValue().getNameMenu())
                    .append(" ".repeat(size[0] - mode.getValue().getNameMenu().length()))
                    .append("   ")
                    .append(mode.getValue().getDesc())
                    .append("\n");
        }
        return main.toString();
    }
}

