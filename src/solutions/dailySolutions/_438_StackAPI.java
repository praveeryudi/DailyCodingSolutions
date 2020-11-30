package src.solutions.dailySolutions;

import java.util.PriorityQueue;

public class _438_StackAPI {

    private static class Entry<T> {
        T data;
        int count;
        Entry(T data) {
            this.data = data;
        }
        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    private static PriorityQueue<Entry> pq = new PriorityQueue<>((e1, e2) -> e2.count - e1.count);

    private static void push(Integer key) {
        Entry<Integer> newEntry = new Entry<>(key);
        if(pq.isEmpty()) {
            pq.offer(newEntry);
            return;
        }
        newEntry.count = pq.peek().count + 1;
        pq.offer(newEntry);
    }

    private static Entry pop() {
        if(pq.isEmpty())
            return null;
        return pq.poll();
    }

    public static void main(String[] args) {
        push(5);
        push(7);
        push(3);
        pop();
        push(10);
        pop();
        System.out.println(pq);
    }

}
