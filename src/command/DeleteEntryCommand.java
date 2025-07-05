package command;

import controller.DiaryManager;
import java.util.Scanner;

public class DeleteEntryCommand implements Command {
    private DiaryManager manager;
    private Scanner scanner;

    public DeleteEntryCommand(DiaryManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter title of entry to delete: ");
        String title = scanner.nextLine();
        manager.deleteEntry(title);
    }
}
