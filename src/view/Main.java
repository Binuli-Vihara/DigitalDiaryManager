package view;

import controller.*;
import command.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DiaryManager manager = new DiaryManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n📖 Digital Diary");
            System.out.println("1. Add Entry");
            System.out.println("2. View Entries");
            System.out.println("3. Update Entry");
            System.out.println("4. Delete Entry");
            System.out.println("5. Search by Mood");
            System.out.println("6. Sort by Date");
            System.out.println("7. Mood Statistics");
            System.out.println("8. Word Count");
            System.out.println("9. Reflection");
            System.out.println("0. Exit");
            System.out.print("📥 Enter your choice (0–9) and press Enter: ");

            String input = scanner.nextLine();
            Command command = null;

            switch (input) {
                case "1":
                    command = new AddEntryCommand(manager, scanner);
                    break;
                case "2":
                    command = new ViewEntriesCommand(manager);
                    break;
                case "3":
                    command = new UpdateEntryCommand(manager, scanner);
                    break;
                case "4":
                    command = new DeleteEntryCommand(manager, scanner);
                    break;
                case "5":
                    System.out.print("😊 Enter mood to search: ");
                    String mood = scanner.nextLine();
                    manager.searchByMood(mood);
                    break;
                case "6":
                    System.out.print("⬇️ Sort descending? (y/n): ");
                    boolean desc = scanner.nextLine().equalsIgnoreCase("y");
                    manager.sortByDate(desc);
                    break;
                case "7":
                    manager.moodStatistics();
                    break;
                case "8":
                    manager.showWordCounts();
                    break;
                case "9":
                    ReflectionUtil.inspectDiaryEntryClass();
                    break;
                case "0":
                    System.out.println("👋 Goodbye!");
                    scanner.close();
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid option.");
                    break;
            }

            if (command != null) {
                command.execute();
            }
        }
    }
}
