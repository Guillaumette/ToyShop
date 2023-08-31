package core.view;

import core.control.Control;
import core.control.ControlBase;
import core.data.ToysManager;
import core.model.Exit;
import core.model.Lottery;
import core.model.Mode;
import core.model.Settings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View implements BaseView {
    private final ControlBase control;

    public View() {
        Mode start = new Lottery();
        Mode setting = new Settings(this);
        Mode exit = new Exit();
        Map<String, Mode> menu = new LinkedHashMap<>();
        menu.put(start.getNameMenu(), start);
        menu.put(start.getNameMenu(), setting);
        menu.put(start.getNameMenu(), exit);
        this.control = new Control(new ToysManager(), menu);
        start(control, "\nПриветствуем вас в магазине игрушек!");
    }

    public View(ControlBase control, String text) {
        this.control = control;
        start(control, text);
    }

    @Override
    public ControlBase getControl() {
        return control;
    }

    @Override
    public void start(ControlBase control, String text) {
        Scanner sc = new Scanner(System.in).useDelimiter("\r?\n");
        System.out.println(text);
        System.out.print(control.toString() + "\n");
        while (true) {
            System.out.print("~");
            String input = sc.next().strip().trim().toLowerCase();
            control.onExecute(input, sc);
        }
    }
}
