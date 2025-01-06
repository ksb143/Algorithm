import java.util.*;

class Solution {
    class Node {
        String key;
        Node prev, next;

        public Node(String key) {
            this.key = key;
        }
    }

    public class LRUCache {
        private HashMap<String, Node> map;
        private Node head, tail;
        private int capacity;
        private int time;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            time = 0;
            this.head = null;
            this.tail = null;
        }
        // 노드 삭제
        private void remove(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
        }

        private void moveToHead(Node node) {
            if (head == null) {
                head = tail = node;
                node.prev = node.next = null;
            } else {
                node.next = head;
                node.prev = null;
                head.prev = node;
                head = node;
            }
        }

        public void put(String key) {
            Node node;
            if (map.containsKey(key)) {
                node = map.get(key);
                remove(node);
                time += 1;
            } else {
                if (map.size() == capacity) {
                    // size가 0인 경우 감안하기
                    if (tail != null) {
                        map.remove(tail.key);
                        remove(tail);
                    }
                }
                node = new Node(key);
                time += 5;
            }
            // 용량이 0이 아니면 집어넣기
            if (capacity != 0) {
                moveToHead(node);
                map.put(key, node);
            }
        }

        public int getTime() {
            return time;
        }
    }
    
    public int solution(int cacheSize, String[] cities) {
        LRUCache cache = new LRUCache(cacheSize);

        for (String city : cities) {
            cache.put(city.toLowerCase());  // 대소문자 통일
        }

        return cache.getTime();
    }
}