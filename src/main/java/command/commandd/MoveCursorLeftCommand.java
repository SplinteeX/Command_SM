package command.commandd;

public class MoveCursorLeftCommand implements Command{
    private PixelArtEditor editor;

    public MoveCursorLeftCommand(PixelArtEditor editor){
        this.editor = editor;

    }
    @Override
    public void execute(){
        editor.moveCursorLeft();
    }
}