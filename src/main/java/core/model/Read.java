package core.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.data.Toy;
import core.data.ToysManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Read extends Mode {

    public Read() {
        super("read", "загрузить из файла");
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        System.out.print("Введите название файла: ");
        String pathFile = sc.next().trim().strip();
        String path = "D:\\Documents\\Программирование\\GeekBrains курс\\1 четверть\\" +
                "ToyShop\\src\\main\\resources\\" + pathFile + ".json";
        List<Toy> tmp;
        ObjectMapper mapper = new ObjectMapper();
        try {
            tmp = Arrays.asList(mapper.readValue(new File(path), Toy[].class));
        } catch (IOException e) {
            System.out.println("Ошибка: файла с таким названием не существует!");
            return;
        }
        toys.setToys(new PriorityQueue<>(tmp));
        System.out.println("~ успешно загружено!");
    }
}
