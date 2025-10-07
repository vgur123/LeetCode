package org.easy;

import java.io.*;

public class IsAriseList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] arr = reader.readLine().split(" ");
        int [] nums = new int[arr.length];

        String result = "YES";

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        for (int i = 1; i < arr.length; i++) {

            if (nums[i] <= nums[i-1]) {
                result = "NO";
            }
        }

        writer.write(result);


        reader.close();
        writer.close();
    }
}
