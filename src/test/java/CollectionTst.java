import org.junit.Test;

import java.util.*;

public class CollectionTst {

    @Test
    public void keySetTest(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        Set<String> ks = map.keySet();

        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

    @Test
    public void arrIterTest(){
        int[] data1 = new int[] { 1, 3, 5, 7, 9 };

        printArray(data1);
        int[] data2 = Arrays.copyOf(data1, 6);
        data2[5] = 11;
        printArray(data2);

        int[] data3 = Arrays.copyOfRange(data1, 2, 10);
        printArray(data3);
    }

    // print array elements
    private static void printArray(int[] data) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(data[i]);
            if (i < data.length - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    @Test
    public void t(){
        HashSet<String>        fruitsStore = new HashSet<>();
        LinkedHashSet<String>  fruitMarket = new LinkedHashSet<>();
        TreeSet<String>        fruitBuzz   = new TreeSet<>();

        for (String fruit : Arrays.asList("mango", "apple", "banana")) {
            fruitsStore.add(fruit);
            fruitMarket.add(fruit);
            fruitBuzz.add(fruit);
        }

        // no ordering in HashSet – elements stored in random order
        System.out.println("Ordering in HashSet :" + fruitsStore);

        // insertion order or elements – LinkedHashSet storeds elements as insertion
        System.err.println("Order of element in LinkedHashSet :" + fruitMarket);

        // should be sorted order – TreeSet stores element in sorted order
        System.out.println("Order of objects in TreeSet :" + fruitBuzz);

        // Performance test to insert 10M elements in HashSet, LinkedHashSet and TreeSet
        Set<Integer> numbers = new HashSet<Integer>();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            numbers.add(i);
        }

        long endTime = System.nanoTime();
        System.out.println("Total time to insert 10M elements in HashSet in sec : " + (endTime - startTime));

        // LinkedHashSet performance Test – inserting 10M objects
        numbers = new LinkedHashSet<Integer>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            numbers.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Total time to insert 10M elements in LinkedHashSet in sec : " + (endTime - startTime));

        // TreeSet performance Test – inserting 10M objects
        numbers = new TreeSet<Integer>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            numbers.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Total time to insert 10M elements in TreeSet in sec : " + (endTime - startTime));

    }


}
