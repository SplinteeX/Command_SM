package command.commandd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditorGUI extends Application implements PixelArtChangeListener {
    private static final int PIXEL_SIZE = 20;
    private PixelArtEditor editor = new PixelArtEditor();

    @Override
    public void start(Stage primaryStage) {
        editor.addChangeListener(this);
        GridPane gridPane = new GridPane();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle pixel = new Rectangle(PIXEL_SIZE, PIXEL_SIZE);
                pixel.setFill(Color.WHITE);
                pixel.setStroke(Color.BLACK);
                gridPane.add(pixel, x, y);
            }
        }

        Button generateCodeButton = new Button("Generate Code");
        generateCodeButton.setOnAction(e -> editor.generateCode());
        // Add the generate code if needed ( Causes problems moving the cursor )
        VBox root = new VBox(gridPane);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    editor.moveCursorUp();
                    break;
                case DOWN:
                    editor.moveCursorDown();
                    break;
                case LEFT:
                    editor.moveCursorLeft();
                    break;
                case RIGHT:
                    editor.moveCursorRight();
                    break;
                case SHIFT:
                    editor.togglePixel();
                    break;
            }
            updateGUI(gridPane);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateGUI(GridPane gridPane) {
        boolean[][] pixels = editor.getPixels();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle pixel = (Rectangle) gridPane.getChildren().get(y * 8 + x);
                if (pixels[y][x]) {
                    pixel.setFill(Color.BLACK);
                } else {
                    pixel.setFill(Color.WHITE);
                }
            }
        }
    }
    @Override
    public void onPixelArtChanged() {
        editor.generateCode();
    }

    public static void main(String[] args) {
        launch(args);
    }
}