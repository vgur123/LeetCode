package org.easy.algorithms;

public class StrToInt {

    static int stringToIntHelper(String str, int index) {

        // Base case: when index reaches the end of the string
        if (index == str.length())
            return 0;

        int digit = str.charAt(index) - '0';

        return digit * (int)Math.pow(10, str.length() - index - 1) + stringToIntHelper(str, index + 1);
    }

    public static void main(String [] arg){
        String str = "1235";
        System.out.println(stringToIntHelper(str, 0));
    }
}
