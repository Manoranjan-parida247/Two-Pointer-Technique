//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way



class LRUCache {
    // Define Node structure for doubly linked list
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    // Constructor for initializing the cache capacity
    LRUCache(int cap) {
        this.capacity = cap;
        this.cache = new HashMap<>();
        
        // Create dummy head and tail nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Function to remove a node from the doubly linked list
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Function to add a node right after the head
    private void addNodeAtHead(Node node) {
        Node nextNode = head.next;

        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    // Function to move a node to the head (mark as recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addNodeAtHead(node);
    }

    // Function to remove the least recently used node (tail.prev)
    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }

    // Get function to return the value corresponding to the key
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node); // Mark as recently used
            return node.value;
        }
        return -1; // Key not found
    }

    // Put function to add or update a key-value pair
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update existing node value and move it to the head
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // Create a new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNodeAtHead(newNode);

            // If the cache exceeds capacity, remove the least recently used node
            if (cache.size() > capacity) {
                Node lru = removeTail();
                cache.remove(lru.key);
            }
        }
    }
}

