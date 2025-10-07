package org.easy;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PhoneInList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String newNum = reader.readLine().replaceAll("[^0-9]", "");

        String[] phoneList = new String[3];
        for (int i = 0; i < 3; i++) {
            String num = reader.readLine();
            phoneList[i] = num.replaceAll("[^0-9]", "");
        }

        for (int i = 0; i < phoneList.length; i++) {
            String nm = phoneList[i];

            if (phoneList[i].length() < 10) {
                nm = "495" + nm;
            }


            if (newNum.substring(newNum.length() - 10)
                    .equals(nm.substring(nm.length() - 10))) {
                writer.write("YES" + "\n");
            } else {
                writer.write("NO" + "\n");
            }
        }


        reader.close();
        writer.close();
    }
}
