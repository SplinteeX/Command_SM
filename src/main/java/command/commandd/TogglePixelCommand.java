package command.commandd;

public class TogglePixelCommand implements Command {
    private PixelArtEditor editor;

    public TogglePixelCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.togglePixel();
    }
}