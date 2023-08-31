package core.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.data.ToysManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Save extends Mode {

    public Save() {
        super("save", "сохранить в файл");
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        System.out.print("Введите название файла: ");
        String pathFile = sc.next().trim().strip();
        String path = "D:\\Documents\\Программирование\\GeekBrains курс\\1 четверть\\" +
                "ToyShop\\src\\main\\resources\\" + pathFile + ".json";
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr;
        try {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(toys.getToys());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } try {
            Files.write(Paths.get(path),
                    jsonStr.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла");
        }
        System.out.println("~ успешно сохранено!");
    }
}
