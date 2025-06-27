package model;

import java.time.LocalDate;

public class DiaryEntry {
    private String title;
    private LocalDate date;
    private String content;
    private String mood;

    public DiaryEntry(String title, LocalDate date, String content, String mood) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.mood = mood;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getMood() {
        return mood;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    // Custom string output
    @Override
    public String toString() {
        return """
               📓 Diary Entry
               ───────────────
               🏷️ Title   : %s
               🗓️ Date    : %s
               😊 Mood    : %s
               📄 Content : %s
               """.formatted(title, date, mood, content);
    }
}
