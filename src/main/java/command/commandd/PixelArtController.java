package command.commandd;

public class PixelArtController {
    private PixelArtEditor editor;
    private Command moveCursorUpCommand;
    private Command moveCursorDownCommand;
    private Command moveCursorLeftCommand;
    private Command moveCursorRightCommand;
    private Command togglePixelCommand;
    private Command generateCodeCommand;

    public PixelArtController(PixelArtEditor editor) {
        this.editor = editor;
        this.moveCursorUpCommand = new MoveCursorUpCommand(editor);
        this.moveCursorDownCommand = new MoveCursorUpCommand(editor);
        this.moveCursorLeftCommand = new MoveCursorLeftCommand(editor);
        this.moveCursorRightCommand = new MoveCursorRightCommand(editor);
        this.togglePixelCommand = new TogglePixelCommand(editor);
        this.generateCodeCommand = new GenerateCodeCommand(editor);
    }
}