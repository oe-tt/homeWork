package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить человека");
    }

    public void execute() {
        consoleUI.addHuman();
    }
}
