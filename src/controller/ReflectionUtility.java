package controller;

import org.reflections.Reflections;
import java.lang.reflect.Modifier;
import java.util.Set;
import command.Command;

public class ReflectionUtility {

    public static void ReflectionCommand() {
        System.out.println("---------- Scanning and listing available command classes:-----\n");

        Reflections reflections = new Reflections("command");

        Set<Class<? extends Command>> commandClasses = reflections.getSubTypesOf(Command.class);

        for (Class<?> cls : commandClasses) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                System.out.print("  ▶ Found command: " + cls.getSimpleName());
                if (Command.class.isAssignableFrom(cls)) {
                    System.out.println("Valid Command");
                } else {
                    System.out.println("does not implement Command interface");
                }
            }
        }

        System.out.println("\nCommand class scan completed.\n");
    }
}
