
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * This class implements a Least Recently Used (LRU) Cache.
 * 
 * Approach: Uses a combination of a Deque (double-ended queue) and a HashMap to track the order of elements and their values.
 * The Deque is used to maintain the order of elements based on their recent usage, and the HashMap is used for O(1) lookups.
 * 
 * Time Complexity: 
 * - get(key): O(1) because we are using a HashMap for lookups and Deque operations (add, remove) are O(1) at the beginning and end.
 * - put(key, value): O(1) because we are using a HashMap for lookups and Deque operations (add, remove) are O(1) at the beginning and end.
 * 
 * Space Complexity: O(capacity) because in the worst case, the Deque and HashMap will store 'capacity' number of elements.
 * 
 * @author [Your Name]
 */
public class LRUCache {
    class LRUCache {
    Deque<Integer> dq;
    int capacity;
    Map<Integer,Integer> map;
    public LRUCache(int capacity) {
        dq=new ArrayDeque<>(capacity); 
        this.capacity=capacity;
        map=new HashMap<>();     
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int res=map.get(key);
        dq.remove(key);
        dq.addFirst(key);
        // if(dq.peekLast()==key){
        // int val=dq.pollLast();
        // dq.offerFirst(val);}
        return res;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            dq.remove(key);
        }
        if(dq.size()>=capacity){
            int lru=dq.pollLast();
            map.remove(lru);
        }
        map.put(key,value);
        dq.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

    public static class Driver {
        public static void main(String[] args) {
            // Test case 1
            LRUCache cache = new LRUCache(2);
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1)); // returns 1
            cache.put(3, 3); // evicts key 2
            System.out.println(cache.get(2)); // returns -1 (not found)

            // Test case 2
            cache = new LRUCache(1);
            cache.put(2, 1);
            System.out.println(cache.get(2)); // returns 1
            cache.put(3, 2); // evicts key 2
            System.out.println(cache.get(2)); // returns -1 (not found)
            System.out.println(cache.get(3)); // returns 2

            // Test case 3
            cache = new LRUCache(10);
            cache.put(10, 13);
            cache.put(3, 17);
            System.out.println(cache.get(6)); // returns -1 (not found)
            cache.put(6, 11);
            System.out.println(cache.get(10)); // returns 13
            cache.put(13, 7);
            System.out.println(cache.get(3)); // returns 17
        }
    }
}
