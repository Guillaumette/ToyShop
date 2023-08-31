package core.model;

import core.control.Control;
import core.control.ControlBase;
import core.data.ToysManager;
import core.view.BaseView;
import core.view.View;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Settings extends Mode {
    protected final BaseView view;

    public Settings(BaseView view) {
        super("settings", "настройки");
        this.view = view;
    }

    public Settings(String nameMenu, String desc, BaseView view) {
        super(nameMenu, desc);
        this.view = view;
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        Mode read = new Read();
        Mode save = new Save();
        Mode add = new Add();
        Mode edit = new Edit();
        Mode watch = new Watch();
        Mode retrn = new Return(view);
        Map<String, Mode> menu = new LinkedHashMap<>();
        menu.put(read.getNameMenu(), read);
        menu.put(read.getNameMenu(), save);
        menu.put(read.getNameMenu(), add);
        menu.put(read.getNameMenu(), edit);
        menu.put(read.getNameMenu(), watch);
        menu.put(read.getNameMenu(), retrn);
        ControlBase control = new Control(toys, menu);
        new View(control, "\n" + this.desc);
    }
}
