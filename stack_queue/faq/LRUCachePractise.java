package dsa.striver.stack_queue.faq;

import java.util.HashMap;
import java.util.Map;

public class LRUCachePractise {

    private Map<Integer, NodeLRUCache> map;
    private int capacity;
    private NodeLRUCache head;
    private NodeLRUCache tail;

    private void deleteNode (NodeLRUCache nodeLRUCache) {

        NodeLRUCache prev = nodeLRUCache.prev;
        NodeLRUCache next = nodeLRUCache.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insertAfterHead (NodeLRUCache nodeLRUCache) {

        NodeLRUCache nextNode = head.next;
        head.next = nodeLRUCache;
        nextNode.prev = nodeLRUCache;
        nodeLRUCache.prev = head;
        nodeLRUCache.next = nextNode;
    }

    public LRUCachePractise(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        head = new NodeLRUCache();
        tail = new NodeLRUCache();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        NodeLRUCache nodeLRUCache = map.get(key);
        int value = nodeLRUCache.value;
        deleteNode(nodeLRUCache);
        insertAfterHead(nodeLRUCache);
        return value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            NodeLRUCache nodeLRUCache = map.get(key);
            nodeLRUCache.value = value;
            deleteNode(nodeLRUCache);
            insertAfterHead(nodeLRUCache);
            return;
        }
        if (map.size() == capacity) {
            NodeLRUCache nodeLRUCache = tail.prev;
            map.remove(nodeLRUCache);
            deleteNode(nodeLRUCache);
        }
        NodeLRUCache nodeLRUCache = new NodeLRUCache(key, value);
        map.put(key, nodeLRUCache);
        insertAfterHead(nodeLRUCache);
    }
}


class NodeLRUCache {

    int key, value;
    NodeLRUCache prev, next;

    public NodeLRUCache() {
        key = value = -1;
        prev = next = null;
    }

    public NodeLRUCache(int key, int value) {

        this.key = key;
        this.value = value;
        prev = next = null;
    }
}