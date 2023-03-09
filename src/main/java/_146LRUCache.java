import java.util.HashMap;

public class _146LRUCache {

    class CacheNode{

        int key;
        int value;
        CacheNode prev;
        CacheNode next;

        public CacheNode(){

        }

        public CacheNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    CacheNode head,tail;
    HashMap<Integer,CacheNode>cacheMap;

    public _146LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();

        head = new CacheNode();
        tail = new CacheNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if(cacheMap==null|| !cacheMap.containsKey(key)) return -1;

        CacheNode node = cacheMap.get(key);
        int val = node.value;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
        return val;
    }

    public void put(int key, int value) {

        CacheNode node;
        if(cacheMap.containsKey(key)){
            node = cacheMap.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        else{
            node = new CacheNode(key,value);
        }
        cacheMap.put(key,node);

        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;

        if(cacheMap.size()>capacity){
            CacheNode prev = tail.prev;
            prev.prev.next = tail;
            tail.prev = prev.prev;
            cacheMap.remove(prev.key);
        }
    }

    public static void main(String[] args) {
        _146LRUCache cache = new _146LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }
}
