module command.commandd {
    requires javafx.controls;
    requires javafx.fxml;


    opens command.commandd to javafx.fxml;
    exports command.commandd;
}