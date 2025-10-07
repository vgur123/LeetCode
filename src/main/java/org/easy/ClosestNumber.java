package org.easy;

import java.io.*;
import java.util.Arrays;

public class ClosestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(reader.readLine());
        String [] arr = reader.readLine().split(" ");
        int target = Integer.parseInt(reader.readLine());

        int [] nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int result=nums[0];
        int minDiff = Math.abs(result - target);

        for (int i = 1; i < arr.length; i++) {
            int currentNumber = nums[i];
            int currentDiff = Math.abs(currentNumber - target);

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result = currentNumber;
            }
        }

        writer.write(String.valueOf(result));


        reader.close();
        writer.close();
    }
}
