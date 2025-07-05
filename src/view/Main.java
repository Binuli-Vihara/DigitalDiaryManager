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
        	System.out.println("""
        	        
        	        📖 Welcome to Your Digital Diary! 📖
        	        ────────────────────────────────
        	        1 -  Add a new entry
        	        2️ -  View all entries
        	        3️ -  Update an existing entry
        	        4️ -  Delete an entry
        	        5️ -  Search entries by mood
        	        6️ -  Sort entries by date
        	        7️ -  View mood statistics
        	        8️ -  Show word count for entries
        	        9️ -  Inspect Diary Manager class (Reflection)
        	        0️ -  Exit the diary
        	        
        	        📥 Please enter your choice (0–9) and press Enter:
        	        """);

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
                    ReflectionUtility.inspectDiaryEntry();
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
