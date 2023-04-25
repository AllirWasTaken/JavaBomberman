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
    public Stage stageF;

    double temp;
    boolean temp2;

    public void Launch(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stageF=stage;
        stage.setTitle("Game Window");
        canvas = new Canvas(manager.screenWidth, manager.screenHeight);
        gc=canvas.getGraphicsContext2D();
        tl=new Timeline(new KeyFrame(Duration.millis(1),e->manager.RunGame(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        canvas.setOnMouseMoved(e ->  temp  = e.getY());
        canvas.setOnMouseClicked(e ->  temp2 = true);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }
}
