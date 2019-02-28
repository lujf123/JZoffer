package code;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class JZ40 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : input) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(2);
        System.out.println(maxHeap.poll());
        System.out.println("---");
        for (Integer i : maxHeap) {
            System.out.println(i);
        }
    }

}
