import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Array, we cannot change its length
        // create an array by assigning the length
        String[] new_arr = new String[5];
        new_arr[0] = "hi";
        String x = new_arr[1];
        System.out.println(x); // null

        // create an array by listing all elements
        double[] new_arr_int = {1,2,5.5,3};
        System.out.println(new_arr_int[2]); // will automatically become double type

        // sorting an array, an in-place operation!
        int[] array = {-5, 6, -1, 13, 99, 2};
        Arrays.sort(array);
        for (int a: array) {
            System.out.println(a);
        }
        // sorting part of the array
        int[] arrayy = {-5, 6, -1, 99, 11, 2};
        Arrays.sort(arrayy, 2, 5); // will sort the [a, b) part
        for (int a: arrayy) {
            System.out.println(a);
        }

        // for loop to iterate in an array
        for (int i=0; i<new_arr_int.length; i++) {
            System.out.println(new_arr_int[i]);
        }
        // a better expression
        int count = 0;
        for (double val: new_arr_int) {
            System.out.println(val + " " + count);
            count ++;
        }

        // do while loop
        Scanner sc = new Scanner(System.in);
        int var;
        do {
            var = sc.nextInt();
            System.out.println("You wrote " + var);
        } while (var != 10);

        // Set
        // HashSet
        Set<Integer> s = new HashSet<Integer>(); // if there is another set, then can put that set into the (), to start with that set
        s.add(5);
        s.add(9);
        s.add(4);
        s.add(9);
        System.out.println(s);
        System.out.println(s.contains(6));
        s.remove(9);
        System.out.println(s);
        System.out.println(s.size());

        // TreeSet, elements are ordered in ascending if we print it out
        Set<Integer> ts = new TreeSet<Integer>();
        ts.add(5);
        ts.add(10);
        ts.add(-6);
        System.out.println(ts);

        // LinkedHashSet, elements are maintained in the order they are inserted
        Set<Integer> lhs = new LinkedHashSet<Integer>();
        lhs.add(25);
        lhs.add(-1);
        lhs.add(5);
        System.out.println(lhs);

        // List
        // ArrayList, can insert, delete, change length
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(2);
        al.add(5);
        al.add(2);
        al.add(5);
        al.add(4);
        al.add(8);
        al.set(1, 3); // the element at this index must already have values, otherwise error
        System.out.println(al.subList(0, 4)); // will return [a, b) elements in the arraylist

        // LinkedList, use a double linked list structure to store elements in the list
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(2);
        ll.add(5);
        ll.add(2);
        ll.add(5);
        ll.add(4);
        ll.add(8);
        ll.set(1, 3); // the element at this index must already have values, otherwise error
        System.out.println(ll.subList(0, 4)); // will return [a, b) elements in the arraylist

        // Map
        // HashMap, does not keep the order of pairs, and the same key can only exist once
        Map m = new HashMap();
        m.put("key", 5);
        m.put(200, 34);
        m.put("newkey", 53);
        System.out.println(m);
        System.out.println(m.get("key"));
        m.containsValue(5); // check if the value exists in the map
        m.containsKey(20); // check if the key exists in the map
        m.values();
        m.remove(200);
        m.clear();

        // TreeMap, keys must be of the same type, and the pairs are sorted by ascending keys
        Map tm = new TreeMap();
        tm.put("key", 5);
        tm.put("newkey", "hi");
        tm.put("akey", "hi");
        System.out.println(tm);
        System.out.println(tm.get("key"));

        // LinkedHashMap, the pairs are ordered by the order that they are added (keys do not need same type)
        Map lhm = new LinkedHashMap();
        lhm.put("key", 5);
        lhm.put(4, "hi");
        lhm.put("akey", "hi");
        System.out.println(lhm);
        System.out.println(lhm.get(4));

        // exercise: count the appearance of words
        ArrayList<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("welcome");
        words.add("hello");
        words.add("me");
        words.add("hi");
        words.add("welcome");
        words.add("me");

        Map<String, Integer> counter = new TreeMap(); // important to pre-specify the types, otherwise may lead to error
        for (String word:words){ // simplifies the loop
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            }
            else {
                counter.put(word, 1);
            }

        }
        System.out.println(counter);

    }
}
