package command.commandd;

import java.util.ArrayList;
import java.util.List;

public class PixelArtEditor {
    private int cursorX = 0;
    private int cursorY = 0;
    private boolean[][] pixels = new boolean[8][8];
    private List<PixelArtChangeListener> listeners = new ArrayList<>();

    public void addChangeListener(PixelArtChangeListener listener) {
        listeners.add(listener);
    }

    private void notifyChange() {
        for (PixelArtChangeListener listener : listeners) {
            listener.onPixelArtChanged();
        }
    }

    public void moveCursorUp() {
        if (cursorY > 0) cursorY--;
        notifyChange();
    }

    public void moveCursorDown() {
        if (cursorY < 7) cursorY++;
        notifyChange();
    }

    public void moveCursorLeft() {
        if (cursorX > 0) cursorX--;
        notifyChange();
    }

    public void moveCursorRight() {
        if (cursorX < 7) cursorX++;
        notifyChange();
    }

    public void moveCursorTo(int x, int y) {
        cursorX = x;
        cursorY = y;
        notifyChange();
    }

    public void togglePixel() {
        pixels[cursorY][cursorX] = !pixels[cursorY][cursorX];
        notifyChange();
    }

    public boolean[][] getPixels() {
        return pixels;
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }

    public void generateCode() {
        System.out.println("int[][] pixelArt = {");
        for (int y = 0; y < pixels.length; y++) {
            System.out.print("    {");
            for (int x = 0; x < pixels[y].length; x++) {
                System.out.print(pixels[y][x] ? "1" : "0");
                if (x < pixels[y].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("},");
        }
        System.out.println("};");
    }
}