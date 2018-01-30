package lesson22.homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lesson20.Point;
import lesson22.homework.views.Main;

public abstract class Drawing extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("lesson22/homework/views/Main.fxml"));

        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 500);

        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, event -> {
            Main main = loader.getController();
            Painter painter = new Painter() {

                {
                    main.getGc().setFill(Color.GREEN);
                    main.getGc().setStroke(Color.BLUE);
                    main.getGc().setLineWidth(1);

                }

                @Override
                public void drawline(Point from, Point to) {
                    main.getGc().strokeLine(from.x, from.y, to.x, to.y);
                }
            };

            new Thread(() -> {
                System.out.println("Start working with console");
                main(painter);
                System.out.println("Buy!!!");
            }).start();
        });

        stage.setTitle("Drawing figure");
        stage.setScene(scene);
        stage.show();
    }

    public abstract void main(Painter painter);
}
