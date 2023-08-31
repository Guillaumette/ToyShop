package core.view;

import core.control.ControlBase;

public interface BaseView {
    public void start(ControlBase control, String text);

    public ControlBase getControl();
}
