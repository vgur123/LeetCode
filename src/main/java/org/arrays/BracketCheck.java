package org.arrays;

public class BracketCheck {

    public static void main(String [] argv){
        String str = "{({[()])}";
        while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        System.out.println (str.length() == 0);
    }
}
