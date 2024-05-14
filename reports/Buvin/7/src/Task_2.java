import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Task_2 extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private int depth = 10; // Глубина рекурсии для построения фрактала

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.setCenter(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        drawSierpinskiTriangle(gc, 50, HEIGHT - 50, WIDTH - 50, HEIGHT - 50, WIDTH / 2, 50, depth);

        primaryStage.setTitle("Sierpinski Triangle");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }

    private void drawSierpinskiTriangle(GraphicsContext gc, double x1, double y1, double x2, double y2, double x3, double y3, int depth) {
        if (depth == 0) {
            gc.setFill(Color.BLACK);
            gc.fillPolygon(new double[]{x1, x2, x3}, new double[]{y1, y2, y3}, 3);
            return;
        }

        double mid1X = (x1 + x2) / 2;
        double mid1Y = (y1 + y2) / 2;
        double mid2X = (x2 + x3) / 2;
        double mid2Y = (y2 + y3) / 2;
        double mid3X = (x1 + x3) / 2;
        double mid3Y = (y1 + y3) / 2;

        drawSierpinskiTriangle(gc, x1, y1, mid1X, mid1Y, mid3X, mid3Y, depth - 1);
        drawSierpinskiTriangle(gc, mid1X, mid1Y, x2, y2, mid2X, mid2Y, depth - 1);
        drawSierpinskiTriangle(gc, mid3X, mid3Y, mid2X, mid2Y, x3, y3, depth - 1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}