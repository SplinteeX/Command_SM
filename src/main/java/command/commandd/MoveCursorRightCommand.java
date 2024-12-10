package command.commandd;

public class MoveCursorRightCommand implements Command{
    private PixelArtEditor editor;

    public MoveCursorRightCommand(PixelArtEditor editor){
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorRight();
    }
}