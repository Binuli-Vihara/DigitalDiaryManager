package controller;

import model.DiaryEntry;
import java.lang.reflect.*;

public class ReflectionUtil {
    public static void inspectDiaryEntryClass() {
        Class<?> clazz = DiaryEntry.class;
        System.out.println("📘 Inspecting DiaryEntry class...");

        System.out.println("\nFields:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("- " + field.getName() + ": " + field.getType().getSimpleName());
        }

        System.out.println("\nMethods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("- " + method.getName());
        }
    }
}
