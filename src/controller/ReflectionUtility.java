package controller;

import model.DiaryEntry;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtility {

    public static void inspectDiaryEntry() {
        Class<?> clazz = DiaryEntry.class;
        System.out.println("\n🔍 Inspecting DiaryEntry class:");

        System.out.println("\nFields:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("- " + field.getName() + " : " + field.getType().getSimpleName());
        }

        System.out.println("\nMethods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("- " + method.getName());
        }
    }
}
