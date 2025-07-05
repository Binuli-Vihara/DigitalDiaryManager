package command;

import controller.DiaryManager;
import java.util.Scanner;

public class UpdateEntryCommand implements Command {
    private final DiaryManager manager;
    private final Scanner scanner;

    public UpdateEntryCommand(DiaryManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("📝 Enter title of the entry to update: ");
        String title = scanner.nextLine();

        System.out.print("📄 Enter new content: ");
        String content = scanner.nextLine();

        System.out.print("😊 Enter new mood: ");
        String mood = scanner.nextLine();

        manager.updateEntry(title, content, mood);
    }
}
