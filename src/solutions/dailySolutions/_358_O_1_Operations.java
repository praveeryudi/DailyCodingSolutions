package solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Create a data structure that performs all the following operations in O(1) time:
 * plus: Add a key with value 1. If the key already exists, increment its value by one.
 * minus: Decrement the value of a key. If the key's value is currently 1, remove it.
 * get_max: Return a key with the highest value.
 * get_min: Return a key with the lowest value.
 * @param <K>
 */
public class _358_O_1_Operations<K> {

    private static class Pair<K> {
        K key;
        Integer value;
        public Pair(K key) {
            this.key = key;
            this.value = 1;
        }
        @Override
        public String toString() {
            return this.key + ":" + this.value;
        }
    }

    private final Map<K, Pair<K>> mapping;
    private PriorityQueue<Pair<K>> maxPriorityQueue;
    private PriorityQueue<Pair<K>> minPriorityQueue;

    public _358_O_1_Operations() {
        this.mapping = new HashMap<>();
        this.maxPriorityQueue = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
        this.minPriorityQueue = new PriorityQueue<>((p1, p2) -> p1.value - p2.value);
    }

    public void plus(K key) {
        if(!mapping.containsKey(key)) {
            Pair<K> p = new Pair<>(key);
            mapping.put(key, p);
            maxPriorityQueue.offer(p);
            minPriorityQueue.offer(p);
            return;
        }

        Pair<K> p = mapping.get(key);
        p.value += 1;
    }

    public void minus(K key) {
        if(!mapping.containsKey(key))
            return;

        Pair<K> p = mapping.get(key);
        if(p.value == 1) {
            mapping.remove(p.key);
            minPriorityQueue.remove(p);
            maxPriorityQueue.remove(p);
            return;
        }
        p.value -= 1;
    }

    public K get_max() {
        return maxPriorityQueue.peek().key;
    }

    public K get_min() {
        return minPriorityQueue.peek().key;
    }

    public void printMapping() {
        System.out.println(this.mapping);
    }

    public static void main(String[] args) {
        _358_O_1_Operations<Integer> obj = new _358_O_1_Operations<>();
        obj.plus(11);
        obj.plus(21);
        obj.plus(11);
        obj.plus(11);
        obj.minus(21);
        obj.plus(13);

        obj.printMapping();
        System.out.println("Max Q: " + obj.maxPriorityQueue);
        System.out.println("Min Q: " + obj.minPriorityQueue);
        System.out.println("Max: " + obj.get_max());
        System.out.println("Min: " + obj.get_min());
    }

}
