package edu.javaschool.core_concepts.advancedfoundations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MapTypeDSTest {
    private static final String[] COMMON_ENTRIES = {
            "England=London",
            "India=New Dehli",
            "Austria=Wien",
            "Norway=Oslo",
            "USA=Washington DC"
    };

    @Test
    void hashMapOutputContainsAllEntriesOnce() throws Exception {
        String output = captureOutput("hashMap");

        assertTrue(output.contains("--- HashMap Demonstration ---"), output::toString);
        String mapLine = extractMapLine(output, "java.util.HashMap");
        assertContainsAllCommonEntries(mapLine);
        assertEquals(1, occurrencesOf(mapLine, "Norway=Oslo"));
    }

    @Test
    void mapHashMapOutputMatchesHashMapBehavior() throws Exception {
        String output = captureOutput("mapHashMap");

        assertTrue(output.contains("--- Map (HashMap implementation) Demonstration ---"), output::toString);
        String mapLine = extractMapLine(output, "java.util.HashMap");
        assertContainsAllCommonEntries(mapLine);
        assertEquals(1, occurrencesOf(mapLine, "Norway=Oslo"));
    }

    @Test
    void treeMapOutputIsSortedByKey() throws Exception {
        String output = captureOutput("treeMap");

        assertTrue(output.contains("--- TreeMap Demonstration ---"), output::toString);
        String mapLine = extractMapLine(output, "java.util.TreeMap");
        assertEquals(
                List.of("Austria=Wien", "England=London", "India=New Dehli", "Norway=Oslo", "USA=Washington DC"),
                parseEntries(mapLine, "java.util.TreeMap"));
    }

    @Test
    void mapTreeMapOutputIsSortedByKey() throws Exception {
        String output = captureOutput("mapTreeMap");

        assertTrue(output.contains("--- Map (TreeMap implementation) Demonstration ---"), output::toString);
        String mapLine = extractMapLine(output, "java.util.TreeMap");
        assertEquals(
                List.of("Austria=Wien", "England=London", "India=New Dehli", "Norway=Oslo", "USA=Washington DC"),
                parseEntries(mapLine, "java.util.TreeMap"));
    }

    @Test
    void linkedHashMapOutputKeepsInsertionOrder() throws Exception {
        String output = captureOutput("linkedHashMap");

        assertTrue(output.contains("--- LinkedHashMap Demonstration ---"), output::toString);
        String mapLine = extractMapLine(output, "java.util.LinkedHashMap");
        assertEquals(
                List.of("England=London", "India=New Dehli", "Austria=Wien", "Norway=Oslo", "USA=Washington DC"),
                parseEntries(mapLine, "java.util.LinkedHashMap"));
    }

    @Test
    void mapLinkedHashMapOutputKeepsInsertionOrder() throws Exception {
        String output = captureOutput("mapLinkedHashMap");

        assertTrue(output.contains("--- Map (LinkedHashMap implementation) Demonstration ---"), output::toString);
        String mapLine = extractMapLine(output, "java.util.LinkedHashMap");
        assertEquals(
                List.of("England=London", "India=New Dehli", "Austria=Wien", "Norway=Oslo", "USA=Washington DC"),
                parseEntries(mapLine, "java.util.LinkedHashMap"));
    }

    private static void assertContainsAllCommonEntries(String mapLine) {
        Arrays.stream(COMMON_ENTRIES)
                .forEach(entry -> assertTrue(mapLine.contains(entry), () -> "Missing entry " + entry + " in " + mapLine));
    }

    private static int occurrencesOf(String text, String token) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(token, index)) != -1) {
            count++;
            index += token.length();
        }
        return count;
    }

    private static String captureOutput(String methodName) throws Exception {
        Method method = MapTypeDS.class.getDeclaredMethod(methodName);
        method.setAccessible(true);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PrintStream intercepted = new PrintStream(outputStream, true, StandardCharsets.UTF_8)) {
            System.setOut(intercepted);
            method.invoke(null);
        } finally {
            System.setOut(originalOut);
        }
        return outputStream.toString(StandardCharsets.UTF_8).trim();
    }

    private static String extractMapLine(String output, String className) {
        return Arrays.stream(output.split("\\R"))
                .filter(line -> line.startsWith(className + " {"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No map line found for " + className + " in output:\n" + output));
    }

    private static List<String> parseEntries(String mapLine, String className) {
        String prefix = className + " {";
        assertTrue(mapLine.startsWith(prefix), () -> "Expected map line to start with " + prefix + ": " + mapLine);
        int closingBrace = mapLine.lastIndexOf('}');
        assertTrue(closingBrace >= 0, () -> "Map line missing closing brace: " + mapLine);
        String body = mapLine.substring(prefix.length(), closingBrace);
        if (body.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(body.split(", "));
    }
}
