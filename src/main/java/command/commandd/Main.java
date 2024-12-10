package command.commandd;

public class Main {
    public static void main(String[] args) {
        PixelArtEditor editor = new PixelArtEditor();
        Command moveRight = new MoveCursorRightCommand(editor);
        Command moveUp = new MoveCursorUpCommand(editor);
        Command togglePixel = new TogglePixelCommand(editor);

        // Test the commands
        moveRight.execute();
        moveUp.execute();
        togglePixel.execute();

        // Generate the code
        editor.generateCode();
    }
}