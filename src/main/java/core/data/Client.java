package core.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Client {
    private final String name;
    private List<String> wins;

    public Client(String name) {
        this.name = name;
        this.wins = new LinkedList<>();
    }

    public void setWins(List<String> wins) {
        this.wins = wins;
    }

    /**
     * @apiNote метод записи результата розыгрыша в файл
     */
    public void toFile() {
        String pathFile = "D:\\Documents\\Программирование\\GeekBrains курс\\1 четверть\\ToyShop\\" +
                "src\\main\\resources\\result.txt";
        try {
            FileWriter file = new FileWriter(pathFile);
            BufferedWriter buf = new BufferedWriter(file);
            buf.write(name + "выиграл:\n");
            for (String win : wins) {
                buf.write(win);
                buf.newLine();
            }
            buf.close();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла" + pathFile);
        }
        System.out.println("~ Результат успешно записан!");
    }
}
