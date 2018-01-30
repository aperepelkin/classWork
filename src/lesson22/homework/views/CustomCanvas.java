package lesson22.homework.views;

import javafx.scene.canvas.Canvas;

public class CustomCanvas extends Canvas {

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public void resize(double width, double height) {
        setWidth(width);
        setHeight(height);
    }
}
