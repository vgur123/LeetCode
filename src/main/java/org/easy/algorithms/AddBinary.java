package org.easy.algorithms;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1; // Pointer for string 'a', starting from the end
        int j = b.length() - 1; // Pointer for string 'b', starting from the end
        int carry = 0;          // Variable to store the carry-over(переходящий остаток)

        while (i >= 0 || j >= 0 || carry == 1) {
             int sum = carry;    // Initialize sum with the current carry

            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int and decrement pointer
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0'; // Convert char to int and decrement pointer
            }
            int tmp = sum % 2;
            sb.append(tmp);                 // Append the current bit (sum modulo 2)
            carry = sum / 2;                // Calculate the new carry (sum divided by 2)
        }

        return sb.reverse().toString();     // Reverse the StringBuilder and convert to String
    }

    public static void main(String [] arg){
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("11","11"));
    }
}
