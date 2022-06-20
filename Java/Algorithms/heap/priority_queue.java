import java.util.*;

public class PriQue {
    public static void main(String[] args) {

        // the default implementation is a min heap
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        pq_min.add(15);
        pq_min.add(35);
        pq_min.add(5);
        while (!pq_min.isEmpty()) {
            System.out.println(pq_min.remove()); // 5 15 35
        }

        // now build a max heap based priority queue
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());
        pq_max.add(16);
        pq_max.add(36);
        pq_max.add(6);
        while (!pq_max.isEmpty()) {
            System.out.println(pq_max.remove()); // 36 16 6
        }

        // a priority queue based on customized comparator
        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        PriorityQueue<String> stringPQ = new PriorityQueue<>(stringLengthComparator);
        stringPQ.add("Hello");
        stringPQ.add("Bye");
        stringPQ.add("OK");
        stringPQ.add("AO");
        while (!stringPQ.isEmpty()) {
            System.out.println(stringPQ.remove()); // OK AO Bye Hello
        }

        // a concise way to define comparator for an array of a pair of int
        PriorityQueue<int[]> pairPQ = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] == pair2[0] ? pair2[1] - pair1[1] : pair2[0] - pair1[0];
            }
        });
        pairPQ.add(new int[]{1,2});
        pairPQ.add(new int[]{1,5});
        pairPQ.add(new int[]{2,4});
        while (!pairPQ.isEmpty()) {
            System.out.println(Arrays.toString(pairPQ.remove())); // [2, 4] [1, 5] [1, 2]
        }

    }
}
