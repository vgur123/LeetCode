package org.easy;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Poisk2Mas {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] noNeed = reader.readLine().split(" ");
        String [] mas1 = reader.readLine().split(" ");
        String [] mas2 = reader.readLine().split(" ");

        Set<Integer> set1 = new HashSet<>();

        for (String s : mas1) {
            try {
                int number = Integer.parseInt(s.trim());
                set1.add(number);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format encountered: " + s);
            }
        }

        for (String s : mas2) {
            try {
                int number = Integer.parseInt(s.trim());
                if (set1.contains(number)){
                    writer.write("YES"+"\n");
                } else {
                    writer.write("NO"+"\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format encountered: " + s);
            }
        }

        reader.close();
        writer.close();
    }
}
