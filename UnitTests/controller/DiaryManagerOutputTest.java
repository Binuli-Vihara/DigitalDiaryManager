package controller;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DiaryManagerOutputTest {

    private DiaryManager manager;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        manager = new DiaryManager();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    void testMoodStatisticsOutput() {
        manager.addEntry("Title1", "Content1", "Happy");
        manager.addEntry("Title2", "Content2", "Sad");
        manager.addEntry("Title3", "Content3", "Happy");

        manager.moodStatistics();

        String output = outContent.toString();
        assertTrue(output.contains("😊 Mood: Happy ➝ 2 entries"));
        assertTrue(output.contains("😊 Mood: Sad ➝ 1 entries"));
    }

    @Test
    void testShowWordCountsOutput() {
        manager.addEntry("Title1", "Hello world", "Happy");
        manager.addEntry("Title2", "One two three four", "Sad");

        manager.showWordCounts();

        String output = outContent.toString();
        assertTrue(output.contains("Title1: 2 words"));
        assertTrue(output.contains("Title2: 4 words"));
    }
}
