package edu.javaschool.core_concepts.advancedfoundations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MapTypeDSTest {
    private static final String[] COMMON_ENTRIES = {
            "England=London",
            "India=New Dehli",
            "Austria=Wien",
            "Norway=Oslo",
            "Norway=Oslo",
            "USA=Washington DC"
    };

    @Test
    void hashMapOutputContainsAllEntriesOnce() throws Exception {
        String output = captureOutput("hashMap");

        assertTrue(output.startsWith("java.util.HashMap"), () -> "Unexpected class prefix: " + output);
        assertContainsAllCommonEntries(output);
        assertEquals(1, occurrencesOf(output, "Norway=Oslo"));
    }

    @Test
    void mapHashMapOutputMatchesHashMapBehavior() throws Exception {
        String output = captureOutput("mapHashMap");

        assertTrue(output.startsWith("java.util.HashMap"), () -> "Unexpected class prefix: " + output);
        assertContainsAllCommonEntries(output);
        assertEquals(1, occurrencesOf(output, "Norway=Oslo"));
    }

    @Test
    void treeMapOutputIsSortedByKey() throws Exception {
        String output = captureOutput("treeMap");

        assertEquals("java.util.TreeMap {Austria=Wien, England=London, India=New Dehli, Norway=Oslo, USA=Washington DC}", output);
    }

    @Test
    void mapTreeMapOutputIsSortedByKey() throws Exception {
        String output = captureOutput("mapTreeMap");

        assertEquals("java.util.TreeMap {Austria=Wien, England=London, India=New Dehli, Norway=Oslo, USA=Washington DC}", output);
    }

    @Test
    void linkedHashMapOutputKeepsInsertionOrder() throws Exception {
        String output = captureOutput("linkedHashMap");

        assertEquals("java.util.LinkedHashMap {England=London, India=New Dehli, Austria=Wien, Norway=Oslo, USA=Washington DC}", output);
    }

    @Test
    void mapLinkedHashMapOutputKeepsInsertionOrder() throws Exception {
        String output = captureOutput("mapLinkedHashMap");

        assertEquals("java.util.LinkedHashMap {England=London, India=New Dehli, Austria=Wien, Norway=Oslo, USA=Washington DC}", output);
    }

    private static void assertContainsAllCommonEntries(String output) {
        Arrays.stream(COMMON_ENTRIES)
                .forEach(entry -> assertTrue(output.contains(entry), () -> "Missing entry " + entry + " in " + output));
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
}
