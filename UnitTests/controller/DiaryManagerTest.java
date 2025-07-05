package controller;

import model.DiaryEntry;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiaryManagerTest {

    private DiaryManager manager;

    @BeforeEach
    void setUp() {
        manager = new DiaryManager();
    }

    @Test
    void testAddEntry() {
        manager.addEntry("Title1", "Content1", "Happy");
        List<DiaryEntry> entries = getEntries(manager);
        assertEquals(1, entries.size());
        assertEquals("Title1", entries.get(0).getTitle());
    }

    @Test
    void testUpdateEntry_success() {
        manager.addEntry("Title1", "Content1", "Happy");
        manager.updateEntry("Title1", "Updated Content", "Sad");

        List<DiaryEntry> entries = getEntries(manager);
        DiaryEntry entry = entries.get(0);
        assertEquals("Updated Content", entry.getContent());
        assertEquals("Sad", entry.getMood());
    }

    @Test
    void testUpdateEntry_failure() {
        manager.updateEntry("NonExisting", "Some Content", "Happy");
        List<DiaryEntry> entries = getEntries(manager);
        assertTrue(entries.isEmpty());
    }

    @Test
    void testDeleteEntry_success() {
        manager.addEntry("Title1", "Content1", "Happy");
        manager.deleteEntry("Title1");
        List<DiaryEntry> entries = getEntries(manager);
        assertTrue(entries.isEmpty());
    }

    @Test
    void testDeleteEntry_failure() {
        manager.addEntry("Title1", "Content1", "Happy");
        manager.deleteEntry("NonExisting");
        List<DiaryEntry> entries = getEntries(manager);
        assertEquals(1, entries.size());
    }


    @Test
    void testSortByDate() {
        manager.addEntry("Title1", "Content1", "Happy");

        assertDoesNotThrow(() -> manager.sortByDate(false));
        assertDoesNotThrow(() -> manager.sortByDate(true));
    }

    private List<DiaryEntry> getEntries(DiaryManager manager) {
        try {
            var field = DiaryManager.class.getDeclaredField("entries");
            field.setAccessible(true);
            return (List<DiaryEntry>) field.get(manager);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
