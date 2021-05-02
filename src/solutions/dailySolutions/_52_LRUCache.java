package src.solutions.dailySolutions;

import java.util.*;

/**
 * Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n,
 * and contain the following methods:
 *
 * 1. set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item,
 * then it should also remove the least recently used item.
 *
 * 2. get(key): gets the value at key. If no such key exists, return null.
 * Each operation should run in O(1) time.
 */
public class _52_LRUCache<T> {

    private static class Node<T> {
        T key;
        Node(T key) {
            this.key = key;
        }
        @Override
        public String toString() {
            return key.toString();
        }
    }

    private int cacheSize;
    private Map<T, Node> map;
    private Deque<Node> cache;

    public _52_LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new LinkedHashMap<>(cacheSize);
        cache = new ArrayDeque<>(cacheSize);
    }

    public T get(T data) {
        if(!map.containsKey(data))
            return null;

        Node<T> node = map.remove(data);
        cache.remove(node);
        map.put(data, node);
        cache.addFirst(node);
        return (T)cache.getFirst().key;
    }

    public void set(T data) {
        Node<T> newNode = new Node<>(data);
        if(cache.size() == cacheSize && !map.containsKey(newNode)) {
            Node<T> cacheData = cache.removeLast();
            Iterator<Map.Entry<T, Node>> mapItr = map.entrySet().iterator();
            while(mapItr.hasNext()) {
                Map.Entry<T, Node> entry = mapItr.next();
                if(entry.getValue().key.equals(cacheData.key)) {
                    mapItr.remove();
                    break;
                }
            }
            cache.addFirst(newNode);
            map.put(data, newNode);
        }
        else if(map.containsKey(data)) {
            Node mapData = map.get(data);
            map.remove(data);
            cache.remove(mapData);

            cache.addFirst(newNode);
            map.put(data, newNode);
        }
        else {
            cache.addFirst(newNode);
            map.put(data, newNode);
        }
    }

    public static void main(String[] args) {
        _52_LRUCache<Integer> lruCache = new _52_LRUCache<>(5);
        lruCache.set(19);
        lruCache.set(11);
        lruCache.set(6);
        System.out.println(lruCache.cache);

        lruCache.get(100);

        lruCache.set(61);
        lruCache.set(22);
        lruCache.set(44);
        System.out.println(lruCache.cache);

        System.out.println(lruCache.cache);
    }
}
