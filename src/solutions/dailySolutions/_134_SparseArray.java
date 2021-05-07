package src.solutions.dailySolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * You have a large array with most of the elements as zero.
 *
 * Use a more space-efficient data structure, SparseArray, that implements the same interface:
 *
 * init(arr, size): initialize with the original large array and size.
 * set(i, val): updates index at i with val.
 * get(i): gets the value at index i.
 */
public class _134_SparseArray {

    private Map<Integer, Integer> map;
    private int size;

    _134_SparseArray(int[] arr) {
        this.map = new HashMap<>();
        this.size = arr.length;
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] != 0) {
                map.put(index, arr[index]);
            }
        }
    }

    boolean isWithinBounds(int index) {
        return index >= 0 && index < size;
    }

    int get(int i) {
        if(!isWithinBounds(i)) {
            throw new RuntimeException("Index out of bounds.");
        }
        return map.getOrDefault(i, 0);
    }

    void set(int i, int val) {
        if(!isWithinBounds(i)) {
            throw new RuntimeException("Index out of bounds.");
        }
        if(val != 0) {
            map.put(i, val);
        }
        else {
            map.remove(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,20,0,0,11};
        _134_SparseArray obj = new _134_SparseArray(arr);
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
        obj.set(4, 0);
        System.out.println(obj.get(4));

        System.out.println(obj.map);
    }

}
