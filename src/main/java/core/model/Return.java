package core.model;

import core.data.ToysManager;
import core.view.BaseView;

import java.util.Scanner;

public class Return extends Settings {

    public Return(BaseView view) {
        super("return", "назад", view);
    }

    @Override
    public void execute(ToysManager toys, Scanner sc) {
        view.start(view.getControl(), "\nОсновное меню");
    }
}
