package org.easy;

import java.io.*;
import java.util.Arrays;

public class NumberInTheMiddle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] arr = reader.readLine().split(" ");
        int [] nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(nums);
        writer.write(String.valueOf(nums[1]));

        reader.close();
        writer.flush();
        writer.close();
    }
}
