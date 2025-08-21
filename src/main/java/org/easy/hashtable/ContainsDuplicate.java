package org.easy.hashtable;

import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String [] arg){
        int [] arr = new int[]{1,2,3,1};
        HashSet<Integer> hs = new HashSet<>();
        boolean res = false;

        for (int i=0; i<arr.length; i++){
            if (!hs.add(arr[i])) res = true;
        }


    }
}
