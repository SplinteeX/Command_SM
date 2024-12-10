package command.commandd;

public class GenerateCodeCommand implements Command {
    private PixelArtEditor editor;

    public GenerateCodeCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.generateCode();
    }
}