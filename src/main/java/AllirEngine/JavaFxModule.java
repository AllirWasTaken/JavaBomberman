package AllirEngine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFxModule extends Application {
    public Canvas canvas;
    public GraphicsContext gc;
    public GameManager manager = GameManager.manager;
    public Timeline tl;


    public void Launch(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        canvas = new Canvas(GameManager.GetCurrentScene().width, GameManager.GetCurrentScene().height);
        gc=canvas.getGraphicsContext2D();
        tl=new Timeline(new KeyFrame(Duration.millis(1),e->manager.RunGame(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }
}
