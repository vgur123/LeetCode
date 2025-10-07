package org.easy;

import java.io.*;
import java.util.*;

public class SequenceType {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> nums = new LinkedList<>();
        String result = "RANDOM";

        boolean isAscending = true;
        boolean isDescending = true;

        int number, prev=0, col=0;

        do {
            number  = Integer.parseInt(reader.readLine());
            col++;
            if (number != prev && number != -2000000000) {
                nums.add(number);
                prev = number;
            }
        } while (number != -2000000000);


        if (nums.size() == 1) {
            result = "CONSTANT";
        } else {

            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) < nums.get(i - 1)) {
                    isAscending = false;
                } else if (nums.get(i) > nums.get(i - 1)) {
                    isDescending = false;
                } else {
                    isAscending = false;
                    isDescending = false;
                }
            }


            if (nums.size() == col-1) {
                if (isAscending) result = "ASCENDING";
                if (isDescending) result = "DESCENDING";
            } else {
                if (isAscending) result = "WEAKLY ASCENDING";
                if (isDescending) result = "WEAKLY DESCENDING";
            }
        }

        writer.write(result);

        reader.close();
        writer.close();

    }
}
