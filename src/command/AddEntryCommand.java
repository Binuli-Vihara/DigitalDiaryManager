package command;

import controller.DiaryManager;
import java.util.Scanner;

public class AddEntryCommand implements Command {
    private DiaryManager manager;
    private Scanner scanner;

    public AddEntryCommand(DiaryManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("🏷️ Enter title: ");
        String title = scanner.nextLine();
        System.out.print("📄 Enter content: ");
        String content = scanner.nextLine();
        System.out.print("😊 Enter mood: ");
        String mood = scanner.nextLine();
        manager.addEntry(title, content, mood);
    }
}