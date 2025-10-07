package org.easy;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWords {
    public static void main(String [] argv) throws IOException {
    //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader reader =
                new BufferedReader(new FileReader("src/main/resources/input.txt"));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = reader.lines()
                .collect(Collectors.joining(System.lineSeparator()));

    Map<String, Integer> wordCount = new HashMap<>();

            String[] words = line.split("\\s+");
            int[] nums = new int[words.length];
            int pos = 0;

            for (String word : words) {
                Integer value = wordCount.get(word);
                if (value == null) {
                    wordCount.put(word, 0);
                    nums[pos++] = 0;
                } else {
                    value += 1;
                    wordCount.put(word, value);
                    nums[pos++] = value;
                }
            }

            Arrays.stream(nums).forEach(v -> System.out.print(v + " "));

        }



}
