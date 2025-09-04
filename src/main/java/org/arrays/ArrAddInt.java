package org.arrays;

import org.easy.algorithms.AddBinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrAddInt {



    public List<Integer> addToArrayForm(int[] arr, int k) {

        List<Integer> ans = new ArrayList<>();
        int arrLen = arr.length - 1; // Pointer for the num array
        int carry = 0;

        // Iterate while there are digits in num, or digits in k, or a carry exists
        while (arrLen >= 0 || k > 0 || carry > 0) {
            int arrVal = 0;
            if (arrLen >= 0) {
                arrVal = arr[arrLen];   // Get the digit from num
            }
                                        //                                       k = 99
            int digitK = k % 10;        // Get the last digit of k               k = 9
            int sum = arrVal + digitK + carry;  //  digit from arr + digit from k + carry_over from previous

            int currentDigit = sum % 10; // The digit to add to the result       18 % 10 = 8
            carry = sum / 10;           // The carry for the next iteration      18 / 10 = 1

            ans.add(currentDigit);  // Add the current digit to the result list  8

            arrLen--;               // Move to the next digit in num
            k /= 10;                // Remove the last digit from                k = 99 / 10 = 9
        }

        Collections.reverse(ans);   // Reverse the list as digits were added from least significant
        return ans;
    }



    public static void main(String [] arg){
        ArrAddInt ab = new ArrAddInt();
        System.out.println(ab.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},99));
    }

}
