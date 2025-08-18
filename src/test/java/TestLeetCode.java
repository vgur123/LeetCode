import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class TestLeetCode {

    @Test
    public void test1() {
        //String num1 = "123456789";
        //String num2 = "987654321";
        String num1 = "123";
        String num2 = "321";

        if (num1.equals("0") || num2.equals("0")) {
            //return "0";
        }
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int l1 = num1.length(), l2 = num2.length();
        int[] res = new int[l1 + l2];

        for (int i = l2 - 1; i >= 0; i--) {
            for (int j = l1 - 1; j >= 0; j--) {
                int product = (ch1[j] - '0') * (ch2[i] - '0');
                int current = product + res[i + j + 1];
                res[i + j + 1] = current % 10;
                res[i + j] += current / 10;
            }
        }
        int index = 0;
        while (index < res.length && res[index] == 0) {
            ++index;
        }

        String result = "";
        while (index < res.length) {
            result += String.valueOf(res[index]);
            index++;
        }
        //return result;
        System.out.println(result);

    }

    @Test
    public void test2() {
        String str = "454n dgdg dgdg   ";
        List<String> lis = new ArrayList<>();
        String word = "";
        str = str.trim();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                lis.add(word);
                word = "";
            } else {
                word += c;
            }
        }
        lis.add(word);
        // return lis.get(lis.size() - 1).length();

        //return res;
    }

    @Test
    public void test3() {
        Integer[] nums1 = {4, 9, 5};
        Integer[] nums2 = {9, 4, 9, 8, 4};

        Integer[] resArr = Stream.of(nums1)
                .filter(Arrays.asList(nums2)::contains)
                .toArray(Integer[]::new);

        Arrays.stream(resArr).forEach(System.out::println);

        Character[] nums3 = {'a', '9', '5'};
        Character[] nums4 = {'9', 'A', '9', '8', '4'};
        Character[] charArr = Stream.of(nums3)
                .map(Character::toUpperCase)
                .filter(Arrays.asList(nums4)::contains)
                .toArray(Character[]::new);

        Arrays.stream(charArr).forEach(System.out::println);
    }

    @Test
    public void test4() {

        int[][] exarray2D = { {1, 2, 3}, {4, 5, 6},{7, 8, 9}};
        int totalElements = 0;

        for (int[] row : exarray2D) {
            totalElements += row.length;
        }

        /*
        int[] original = {9, 4};
        int m = 1, n = 2;
        if (m<=1 && n<=1) return new int [0];
        int[][] res = new int[m][n];

        int i = 0;

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                res[j][k] = original[i++];
            }
        }
         */
        System.out.println(totalElements);
    }

    @Test
    public void t(){
        Stream<Integer> numStream = Stream.of(10, 20, 30);
        numStream.map(n -> n + 10) //.peek(s -> System.out.print(s))
        .forEach(s -> System.out.println(s));
    }

    @Test
    public void powerTest(){
        System.out.println(powerOfN(4, 2));
    }

    // степень n число m
    public int powerOfN(int n, int m) {
        if (n == 0) {
            return 1;
        } else {
            int res = powerOfN(n - 1, m);
            return res * m;
        }
    }

    @Test
    public void binaryTest(){
        System.out.println(toBinary(177));
    }

    // Преобразование в двоичную систему
    public String toBinary(int n) {
        if (n <= 1 ) {
            return String.valueOf(n);
        }
        String res = toBinary(n / 2);
        String ostatok = String.valueOf(n % 2);
        return res + ostatok;
    }

}
