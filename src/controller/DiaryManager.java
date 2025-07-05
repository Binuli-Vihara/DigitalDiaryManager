package controller;

import model.DiaryEntry;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DiaryManager {
    private final List<DiaryEntry> entries = new ArrayList<>();

    public void addEntry(String title, String content, String mood) {
        entries.add(new DiaryEntry(title, LocalDate.now(), content, mood));
        System.out.println("✅ Entry added.");
    }

    public void viewEntries() {
        if (entries.isEmpty()) {
            System.out.println("❌ No entries found.");
        } else {
            int i = 1;
            for (DiaryEntry entry : entries) {
                System.out.println("📘 Entry #" + (i++) + ":\n" + entry);
                System.out.println("——————————————");
            }
        }
    }

    public void updateEntry(String title, String newContent, String newMood) {
        entries.stream()
            .filter(e -> e.getTitle().equalsIgnoreCase(title))
            .findFirst()
            .ifPresentOrElse(e -> {
                e.setContent(newContent);
                e.setMood(newMood);
                System.out.println("✅ Entry updated.");
            }, () -> System.out.println("❌ Entry not found."));
    }

    public void deleteEntry(String title) {
        boolean removed = entries.removeIf(e -> e.getTitle().equalsIgnoreCase(title));
        System.out.println(removed ? "✅ Entry deleted." : "❌ Entry not found.");
    }

    public void searchByMood(String mood) {
        List<DiaryEntry> filtered = entries.stream()
            .filter(e -> e.getMood().equalsIgnoreCase(mood))
            .toList();

        if (filtered.isEmpty()) {
            System.out.println("❌ No entries found with mood: " + mood);
        } else {
            filtered.forEach(System.out::println);
        }
    }

    public void sortByDate(boolean descending) {
        Comparator<DiaryEntry> comparator = Comparator.comparing(DiaryEntry::getDate);
        if (descending) comparator = comparator.reversed();
        entries.stream().sorted(comparator).forEach(System.out::println);
    }

    public void moodStatistics() {
        Map<String, Long> stats = entries.stream()
            .collect(Collectors.groupingBy(DiaryEntry::getMood, Collectors.counting()));

        if (stats.isEmpty()) {
            System.out.println("❌ No entries to calculate mood statistics.");
        } else {
            stats.forEach((mood, count) ->
                System.out.println("😊 Mood: " + mood + " ➝ " + count + " entries"));
        }
    }

    public void showWordCounts() {
        if (entries.isEmpty()) {
            System.out.println("❌ No entries available to count words.");
        } else {
            entries.forEach(e -> {
                String content = Optional.ofNullable(e.getContent()).orElse("");
                int count = content.trim().isEmpty() ? 0 : content.trim().split("\\s+").length;
                System.out.println("📄 " + e.getTitle() + ": " + count + " words");
            });
        }
    }
}
