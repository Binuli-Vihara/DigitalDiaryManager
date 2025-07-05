package tests;

import model.DiaryEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryEntryTest {

    private DiaryEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new DiaryEntry("Test Title", LocalDate.of(2025, 7, 5), "Test content", "Happy");
    }

    @Test
    public void testGetters() {
        assertEquals("Test Title", entry.getTitle());
        assertEquals(LocalDate.of(2025, 7, 5), entry.getDate());
        assertEquals("Test content", entry.getContent());
        assertEquals("Happy", entry.getMood());
    }

    @Test
    public void testSetters() {
        entry.setTitle("Updated Title");
        entry.setDate(LocalDate.of(2024, 1, 1));
        entry.setContent("Updated content");
        entry.setMood("Sad");

        assertEquals("Updated Title", entry.getTitle());
        assertEquals(LocalDate.of(2024, 1, 1), entry.getDate());
        assertEquals("Updated content", entry.getContent());
        assertEquals("Sad", entry.getMood());
    }

    @Test
    public void testToStringNotNull() {
        assertNotNull(entry.toString());
        assertTrue(entry.toString().contains("Diary Entry"));
    }
}
