import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Task_1 extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final Color RED = Color.RED;
    private static final Color BLACK = Color.BLACK;

    private double angle = 0;
    private double centerX = WIDTH / 2;
    private double centerY = HEIGHT / 2;
    private double width = 100;
    private double height = 80;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotating Quadrilateral");
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, WIDTH, HEIGHT);
                drawRotatedQuadrilateral(gc);
                angle += 1;
            }
        }.start();
    }

    private void drawRotatedQuadrilateral(GraphicsContext gc) {
        gc.setFill(RED);
        gc.setStroke(BLACK);

        double[] xPoints = {centerX, centerX + width, centerX + width, centerX};
        double[] yPoints = {centerY, centerY, centerY + height, centerY + height};

        // Поворачиваем точки вокруг центра
        for (int i = 0; i < xPoints.length; i++) {
            double newX = centerX + (xPoints[i] - centerX) * Math.cos(Math.toRadians(angle))
                    - (yPoints[i] - centerY) * Math.sin(Math.toRadians(angle));
            double newY = centerY + (xPoints[i] - centerX) * Math.sin(Math.toRadians(angle))
                    + (yPoints[i] - centerY) * Math.cos(Math.toRadians(angle));
            xPoints[i] = newX;
            yPoints[i] = newY;
        }

        gc.strokePolygon(xPoints, yPoints, 4);
    }

    public static void main(String[] args) {
        launch(args);
    }
}