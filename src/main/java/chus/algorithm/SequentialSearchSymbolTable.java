package chus.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SequentialSearchSymbolTable<K, V> {
    private Node first;
    private int size = 0;

    private class Node {
        K key;
        V val;
        Node next;

        public Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public void put(K key, V val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        size++;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public Iterator<K> keys() {
        List<K> kl = new ArrayList<>();
        for (Node x = first; x != null; x = x.next) {
            if (x.val != null) {
                kl.add(x.key);
            }
        }
        return kl.stream().iterator();
    }

    public void delete(K key) {
        if (first.key.equals(key)) {
            first = first.next;
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (x.next.key.equals(key)) {
                x.next = x.next.next;
                break;
            }
        }
    }

}
