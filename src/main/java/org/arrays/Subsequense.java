package org.arrays;

public class Subsequense {


    static boolean issubsequence(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(j);
            if (ch1 == ch2) i++;
            j++;
        }
        return i == n;
    }

    public static void main(String [] args){
        String s1 = "gksrek";
        String s2 = "geeksforgeeks";
        if (issubsequence(s1, s2))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
