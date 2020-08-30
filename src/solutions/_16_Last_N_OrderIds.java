package src.solutions;

/**
 * You run an e-commerce website and want to record the last N order ids in a log.
 * Implement a data structure to accomplish this, with the following API:
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
 */

public class _16_Last_N_OrderIds {

    private static class LogRecord {
        private int size;
        private int currIndex;
        private int[] logArr;

        LogRecord(int size) {
            this.size = size;
            this.logArr = new int[size];
        }

        void addLog(int orderId) {
            logArr[currIndex] = orderId;
            currIndex = (currIndex + 1) % size;
        }

        int getLastIth(int i) {
            return logArr[(currIndex - i + size) % size];
        }
    }

    public static void main(String[] args) {
        LogRecord logRecord = new LogRecord(5);
        logRecord.addLog(4);
        logRecord.addLog(1);
        logRecord.addLog(8);
        logRecord.addLog(2);
        logRecord.addLog(3);

        int secondLast = logRecord.getLastIth(2); // Gets the 2nd last
        System.out.println("Second Last = " + secondLast);

        int fifthFromLast = logRecord.getLastIth(5); // Gets the 2nd last
        System.out.println("Fifth Last = " + fifthFromLast);
    }

}
