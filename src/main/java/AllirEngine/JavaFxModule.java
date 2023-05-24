package AllirEngine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFxModule extends Application {
    public Canvas canvas;
    public GraphicsContext gc;
    public GameManager manager;
    public Timeline tl;
    public Stage stageF;
    public Group group;



    public void Launch(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        manager=GameManager.manager;
        stageF=stage;
        stage.setTitle("Game Window");
        canvas = new Canvas(manager.screenWidth, manager.screenHeight);
        group= new Group(canvas);
        manager.group=group;
        gc=canvas.getGraphicsContext2D();
        tl=new Timeline(new KeyFrame(Duration.millis(1),e->manager.RunGame(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        stage.setScene(new Scene(group,manager.screenWidth,manager.screenHeight));
        stage.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            Input.RegisterKey(key.getCode());
        });
        stage.getScene().addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            Input.RemoveKeyFromRegister(key.getCode());
        });
        stage.getScene().addEventHandler(MouseEvent.MOUSE_MOVED, (key) -> {
            Input.mousePosition=new Vector2((float)key.getX(),(float)key.getY());
        });
        stage.getScene().addEventHandler(MouseEvent.MOUSE_PRESSED, (key) -> {
            Input.HandleMouse(true);

        });
        stage.getScene().addEventHandler(MouseEvent.MOUSE_RELEASED, (key) -> {
            Input.HandleMouse(false);
        });
        stage.show();
        tl.play();
    }
}
