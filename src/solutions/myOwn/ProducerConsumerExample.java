package src.solutions.myOwn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerExample {

    private static class Producer implements Runnable {
        private BlockingQueue<Integer> sharedQueue;
        private List<Integer> dataSet;
        private AtomicInteger count = new AtomicInteger(0);

        Producer(BlockingQueue<Integer> sharedQueue, List<Integer> dataSet) {
            this.sharedQueue = sharedQueue;
            this.dataSet = dataSet;
        }

        @Override
        public void run() {
            while(count.get() < dataSet.size()) {
                System.out.println("Added element :: " + (1 + count.get()));
                sharedQueue.add(dataSet.get(count.getAndIncrement()));
            }
            System.out.println("Added all elements");
        }
    }

    private static class Consumer implements Runnable {
        private BlockingQueue<Integer> sharedQueue;
        private AtomicInteger count = new AtomicInteger(0);

        Consumer(BlockingQueue<Integer> sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Integer num = sharedQueue.take();
                    System.out.println("Consumed " + num + " by thread " + Thread.currentThread().getName());
                    count.getAndIncrement();
                    if(count.get() == 10)
                        break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue<Integer> bq = new LinkedBlockingDeque<>();
        List<Integer> dataSet = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            dataSet.add(i);
        }
        Producer prod = new Producer(bq, dataSet);
        Thread p1 = new Thread(prod, "Prod1");

        Consumer consumer = new Consumer(bq);
        Thread c1 = new Thread(consumer, "Con1");
        Thread c2 = new Thread(consumer, "Con2");
        Thread c3 = new Thread(consumer, "Con3");

        c3.start();
        c2.start();
        c1.start();

        p1.start();
    }

}
